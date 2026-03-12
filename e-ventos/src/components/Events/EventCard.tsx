import { format } from 'date-fns';
import { ptBR } from 'date-fns/locale';
import type { Event } from '../../types/event';
import { Badge } from '../UI/Badge';
import { Button } from '../UI/Button';

interface EventCardProps {
  event: Event;
  onEdit: (event: Event) => void;
  onDelete: (event: Event) => void;
}

export function EventCard({ event, onEdit, onDelete }: EventCardProps) {
  const formattedDate = format(
    new Date(event.event_date),
    "d 'de' MMMM 'de' yyyy 'às' HH:mm",
    { locale: ptBR }
  );

  return (
    <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5 hover:shadow-md transition-shadow">
      <div className="flex items-start justify-between mb-3">
        <h3 className="text-lg font-semibold text-gray-900 line-clamp-2">
          {event.title}
        </h3>
        <Badge status={event.status} />
      </div>

      {event.description && (
        <p className="text-gray-600 text-sm mb-3 line-clamp-2">
          {event.description}
        </p>
      )}

      <div className="space-y-2 mb-4">
        {event.location && (
          <div className="flex items-center text-sm text-gray-500">
            <span className="mr-2">📍</span>
            <span>{event.location}</span>
          </div>
        )}
        <div className="flex items-center text-sm text-gray-500">
          <span className="mr-2">🗓️</span>
          <span>{formattedDate}</span>
        </div>
      </div>

      <div className="flex items-center gap-2 pt-3 border-t border-gray-100">
        <Button
          variant="ghost"
          size="sm"
          onClick={() => onEdit(event)}
          className="flex-1"
        >
          <svg className="w-4 h-4 mr-1" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
          </svg>
          Editar
        </Button>
        <Button
          variant="ghost"
          size="sm"
          onClick={() => onDelete(event)}
          className="flex-1 text-red-600 hover:bg-red-50"
        >
          <svg className="w-4 h-4 mr-1" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
          </svg>
          Excluir
        </Button>
      </div>
    </div>
  );
}
