import { useState, useCallback, useRef } from 'react';
import { supabase } from '../lib/supabase';
import type { Event, CreateEventDTO, EventFilters, PaginationState } from '../types/event';

const PAGE_SIZE = 12;

const DEFAULT_FILTERS: EventFilters = {
  status: 'all',
  search: '',
  dateFrom: '',
  dateTo: '',
  sortField: 'event_date',
  sortOrder: 'asc',
};

interface UseEventsReturn {
  events: Event[];
  loading: boolean;
  loadingMore: boolean;
  error: string | null;
  filters: EventFilters;
  pagination: PaginationState;
  setFilters: (filters: Partial<EventFilters>) => void;
  fetchEvents: (reset?: boolean) => Promise<void>;
  loadMore: () => Promise<void>;
  createEvent: (data: CreateEventDTO) => Promise<{ error: string | null }>;
  updateEvent: (id: string, data: Partial<CreateEventDTO>) => Promise<{ error: string | null }>;
  deleteEvent: (id: string) => Promise<{ error: string | null }>;
  updateEventStatuses: () => Promise<void>;
}

export function useEvents(): UseEventsReturn {
  const [events, setEvents] = useState<Event[]>([]);
  const [loading, setLoading] = useState(false);
  const [loadingMore, setLoadingMore] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [filters, setFiltersState] = useState<EventFilters>(DEFAULT_FILTERS);
  const [pagination, setPagination] = useState<PaginationState>({
    page: 0,
    pageSize: PAGE_SIZE,
    total: 0,
    hasMore: true,
  });
  
  const abortControllerRef = useRef<AbortController | null>(null);

  const setFilters = useCallback((newFilters: Partial<EventFilters>) => {
    setFiltersState(prev => ({ ...prev, ...newFilters }));
  }, []);

  const buildQuery = useCallback((page: number) => {
    let query = supabase
      .from('events')
      .select('*', { count: 'exact' });

    if (filters.status && filters.status !== 'all') {
      query = query.eq('status', filters.status);
    }

    if (filters.search) {
      query = query.or(`title.ilike.%${filters.search}%,description.ilike.%${filters.search}%`);
    }

    if (filters.dateFrom) {
      query = query.gte('event_date', new Date(filters.dateFrom).toISOString());
    }

    if (filters.dateTo) {
      const endDate = new Date(filters.dateTo);
      endDate.setHours(23, 59, 59, 999);
      query = query.lte('event_date', endDate.toISOString());
    }

    query = query.order(filters.sortField, { ascending: filters.sortOrder === 'asc' });

    const from = page * PAGE_SIZE;
    const to = from + PAGE_SIZE - 1;
    query = query.range(from, to);

    return query;
  }, [filters]);

  const fetchEvents = useCallback(async (reset = true) => {
    if (abortControllerRef.current) {
      abortControllerRef.current.abort();
    }
    abortControllerRef.current = new AbortController();

    if (reset) {
      setLoading(true);
      setEvents([]);
      setPagination(prev => ({ ...prev, page: 0, hasMore: true }));
    }
    setError(null);

    try {
      const query = buildQuery(reset ? 0 : pagination.page);
      const { data, error: fetchError, count } = await query;

      if (fetchError) {
        setError(fetchError.message);
        return;
      }

      const fetchedEvents = data || [];
      const total = count || 0;

      if (reset) {
        setEvents(fetchedEvents);
      } else {
        setEvents(prev => [...prev, ...fetchedEvents]);
      }

      setPagination(prev => ({
        ...prev,
        page: reset ? 0 : prev.page,
        total,
        hasMore: fetchedEvents.length === PAGE_SIZE,
      }));
    } catch (err) {
      if ((err as Error).name !== 'AbortError') {
        setError('Erro ao carregar eventos');
      }
    } finally {
      setLoading(false);
    }
  }, [buildQuery, pagination.page]);

  const loadMore = useCallback(async () => {
    if (loadingMore || !pagination.hasMore) return;

    setLoadingMore(true);
    const nextPage = pagination.page + 1;

    try {
      const query = buildQuery(nextPage);
      const { data, error: fetchError, count } = await query;

      if (fetchError) {
        setError(fetchError.message);
        return;
      }

      const fetchedEvents = data || [];
      const total = count || 0;

      setEvents(prev => [...prev, ...fetchedEvents]);
      setPagination(prev => ({
        ...prev,
        page: nextPage,
        total,
        hasMore: fetchedEvents.length === PAGE_SIZE,
      }));
    } catch (err) {
      setError('Erro ao carregar mais eventos');
    } finally {
      setLoadingMore(false);
    }
  }, [buildQuery, loadingMore, pagination.hasMore, pagination.page]);

  const updateEventStatuses = useCallback(async () => {
    const now = new Date();

    try {
      const { data: eventsToUpdate } = await supabase
        .from('events')
        .select('id, event_date, event_end_date, status')
        .in('status', ['upcoming', 'ongoing']);

      if (!eventsToUpdate || eventsToUpdate.length === 0) return;

      const updates: { id: string; status: 'ongoing' | 'finished' }[] = [];

      for (const event of eventsToUpdate) {
        const eventStart = new Date(event.event_date);
        const eventEnd = event.event_end_date 
          ? new Date(event.event_end_date) 
          : new Date(eventStart.getTime() + 2 * 60 * 60 * 1000); // Default 2 hours duration

        if (event.status === 'upcoming' && now >= eventStart && now < eventEnd) {
          updates.push({ id: event.id, status: 'ongoing' });
        } else if ((event.status === 'upcoming' || event.status === 'ongoing') && now >= eventEnd) {
          updates.push({ id: event.id, status: 'finished' });
        }
      }

      for (const update of updates) {
        await supabase
          .from('events')
          .update({ status: update.status })
          .eq('id', update.id);
      }

      if (updates.length > 0) {
        setEvents(prev => prev.map(event => {
          const update = updates.find(u => u.id === event.id);
          return update ? { ...event, status: update.status } : event;
        }));
      }
    } catch (err) {
      console.error('Erro ao atualizar status dos eventos:', err);
    }
  }, []);

  const createEvent = useCallback(async (data: CreateEventDTO) => {
    setError(null);

    try {
      const { data: { user } } = await supabase.auth.getUser();
      
      if (!user) {
        const errorMessage = 'Usuário não autenticado';
        setError(errorMessage);
        return { error: errorMessage };
      }

      const { error: insertError } = await supabase
        .from('events')
        .insert([{ ...data, user_id: user.id }]);

      if (insertError) {
        setError(insertError.message);
        return { error: insertError.message };
      }

      return { error: null };
    } catch (err) {
      const errorMessage = 'Erro ao criar evento';
      setError(errorMessage);
      return { error: errorMessage };
    }
  }, []);

  const updateEvent = useCallback(async (id: string, data: Partial<CreateEventDTO>) => {
    setError(null);

    try {
      const { error: updateError } = await supabase
        .from('events')
        .update(data)
        .eq('id', id);

      if (updateError) {
        setError(updateError.message);
        return { error: updateError.message };
      }

      return { error: null };
    } catch (err) {
      const errorMessage = 'Erro ao atualizar evento';
      setError(errorMessage);
      return { error: errorMessage };
    }
  }, []);

  const deleteEvent = useCallback(async (id: string) => {
    setError(null);

    try {
      const { error: deleteError } = await supabase
        .from('events')
        .delete()
        .eq('id', id);

      if (deleteError) {
        setError(deleteError.message);
        return { error: deleteError.message };
      }

      setEvents(prev => prev.filter(event => event.id !== id));
      setPagination(prev => ({ ...prev, total: prev.total - 1 }));

      return { error: null };
    } catch (err) {
      const errorMessage = 'Erro ao excluir evento';
      setError(errorMessage);
      return { error: errorMessage };
    }
  }, []);

  return {
    events,
    loading,
    loadingMore,
    error,
    filters,
    pagination,
    setFilters,
    fetchEvents,
    loadMore,
    createEvent,
    updateEvent,
    deleteEvent,
    updateEventStatuses,
  };
}
