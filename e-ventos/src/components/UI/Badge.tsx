import type { EventStatus } from '../../types/event';

interface BadgeProps {
  status: EventStatus;
}

const statusConfig: Record<EventStatus, { label: string; className: string }> = {
  upcoming: {
    label: 'Agendado',
    className: 'bg-blue-100 text-blue-800',
  },
  ongoing: {
    label: 'Em andamento',
    className: 'bg-green-100 text-green-800',
  },
  finished: {
    label: 'Finalizado',
    className: 'bg-gray-100 text-gray-800',
  },
  cancelled: {
    label: 'Cancelado',
    className: 'bg-red-100 text-red-800',
  },
};

export function Badge({ status }: BadgeProps) {
  const config = statusConfig[status];

  return (
    <span className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium ${config.className}`}>
      {config.label}
    </span>
  );
}
