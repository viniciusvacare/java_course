import { useEffect, useRef, useCallback } from 'react';
import type { Event } from '../../types/event';
import { EventCard } from './EventCard';

interface EventListProps {
  events: Event[];
  loading: boolean;
  loadingMore: boolean;
  hasMore: boolean;
  onEdit: (event: Event) => void;
  onDelete: (event: Event) => void;
  onLoadMore: () => void;
}

export function EventList({ 
  events, 
  loading, 
  loadingMore, 
  hasMore, 
  onEdit, 
  onDelete, 
  onLoadMore 
}: EventListProps) {
  const observerRef = useRef<IntersectionObserver | null>(null);
  const loadMoreRef = useRef<HTMLDivElement | null>(null);

  const handleObserver = useCallback((entries: IntersectionObserverEntry[]) => {
    const [entry] = entries;
    if (entry.isIntersecting && hasMore && !loadingMore && !loading) {
      onLoadMore();
    }
  }, [hasMore, loadingMore, loading, onLoadMore]);

  useEffect(() => {
    if (observerRef.current) {
      observerRef.current.disconnect();
    }

    observerRef.current = new IntersectionObserver(handleObserver, {
      root: null,
      rootMargin: '100px',
      threshold: 0,
    });

    if (loadMoreRef.current) {
      observerRef.current.observe(loadMoreRef.current);
    }

    return () => {
      if (observerRef.current) {
        observerRef.current.disconnect();
      }
    };
  }, [handleObserver]);

  if (loading) {
    return (
      <div className="flex items-center justify-center py-12">
        <div className="animate-spin rounded-full h-8 w-8 border-b-2 border-indigo-600"></div>
      </div>
    );
  }

  if (events.length === 0) {
    return (
      <div className="text-center py-12">
        <div className="text-gray-400 text-5xl mb-4">📅</div>
        <h3 className="text-lg font-medium text-gray-900 mb-1">
          Nenhum evento encontrado
        </h3>
        <p className="text-gray-500">
          Tente ajustar os filtros ou crie um novo evento.
        </p>
      </div>
    );
  }

  return (
    <div>
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
        {events.map((event) => (
          <EventCard
            key={event.id}
            event={event}
            onEdit={onEdit}
            onDelete={onDelete}
          />
        ))}
      </div>

      <div ref={loadMoreRef} className="py-4">
        {loadingMore && (
          <div className="flex items-center justify-center py-4">
            <div className="animate-spin rounded-full h-6 w-6 border-b-2 border-indigo-600"></div>
            <span className="ml-2 text-sm text-gray-500">Carregando mais eventos...</span>
          </div>
        )}
        {!hasMore && events.length > 0 && (
          <p className="text-center text-sm text-gray-500 py-4">
            Todos os eventos foram carregados
          </p>
        )}
      </div>
    </div>
  );
}
