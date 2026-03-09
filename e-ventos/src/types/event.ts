export type EventStatus = 'upcoming' | 'ongoing' | 'finished' | 'cancelled';

export type SortField = 'event_date' | 'title' | 'status' | 'created_at';
export type SortOrder = 'asc' | 'desc';

export interface Event {
  id: string;
  title: string;
  description?: string;
  location?: string;
  event_date: string;
  event_end_date?: string;
  status: EventStatus;
  created_at: string;
  user_id: string;
}

export type CreateEventDTO = Omit<Event, 'id' | 'created_at' | 'user_id'>;

export interface EventFormData {
  title: string;
  description: string;
  location: string;
  event_date: string;
  event_end_date: string;
  status: EventStatus;
}

export interface EventFilters {
  status: EventStatus | 'all';
  search: string;
  dateFrom: string;
  dateTo: string;
  sortField: SortField;
  sortOrder: SortOrder;
}

export interface PaginationState {
  page: number;
  pageSize: number;
  total: number;
  hasMore: boolean;
}
