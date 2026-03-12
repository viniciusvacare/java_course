import { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import type { Event, EventFormData, EventStatus } from '../../types/event';
import { Button } from '../UI/Button';

interface EventFormProps {
  event?: Event | null;
  onSubmit: (data: EventFormData) => Promise<void>;
  onCancel: () => void;
  loading?: boolean;
}

const statusOptions: { value: EventStatus; label: string }[] = [
  { value: 'upcoming', label: 'Agendado' },
  { value: 'ongoing', label: 'Em andamento' },
  { value: 'finished', label: 'Finalizado' },
  { value: 'cancelled', label: 'Cancelado' },
];

function formatDateTimeLocal(dateString: string): string {
  if (!dateString) return '';
  const date = new Date(dateString);
  return new Date(date.getTime() - date.getTimezoneOffset() * 60000)
    .toISOString()
    .slice(0, 16);
}

export function EventForm({ event, onSubmit, onCancel, loading }: EventFormProps) {
  const { register, handleSubmit, reset, watch, formState: { errors } } = useForm<EventFormData>({
    defaultValues: {
      title: '',
      description: '',
      location: '',
      event_date: '',
      event_end_date: '',
      status: 'upcoming',
    },
  });

  const eventDate = watch('event_date');

  useEffect(() => {
    if (event) {
      reset({
        title: event.title,
        description: event.description || '',
        location: event.location || '',
        event_date: formatDateTimeLocal(event.event_date),
        event_end_date: event.event_end_date ? formatDateTimeLocal(event.event_end_date) : '',
        status: event.status,
      });
    } else {
      reset({
        title: '',
        description: '',
        location: '',
        event_date: '',
        event_end_date: '',
        status: 'upcoming',
      });
    }
  }, [event, reset]);

  const handleFormSubmit = async (data: EventFormData) => {
    await onSubmit(data);
  };

  return (
    <form onSubmit={handleSubmit(handleFormSubmit)} className="space-y-4">
      <div>
        <label htmlFor="title" className="block text-sm font-medium text-gray-700 mb-1">
          Título *
        </label>
        <input
          id="title"
          type="text"
          {...register('title', { required: 'Título é obrigatório' })}
          className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
          placeholder="Nome do evento"
        />
        {errors.title && (
          <p className="mt-1 text-sm text-red-600">{errors.title.message}</p>
        )}
      </div>

      <div>
        <label htmlFor="description" className="block text-sm font-medium text-gray-700 mb-1">
          Descrição
        </label>
        <textarea
          id="description"
          {...register('description')}
          rows={3}
          className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors resize-none"
          placeholder="Descreva o evento..."
        />
      </div>

      <div>
        <label htmlFor="location" className="block text-sm font-medium text-gray-700 mb-1">
          Local
        </label>
        <input
          id="location"
          type="text"
          {...register('location')}
          className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
          placeholder="Onde será o evento"
        />
      </div>

      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4">
        <div>
          <label htmlFor="event_date" className="block text-sm font-medium text-gray-700 mb-1">
            Início *
          </label>
          <input
            id="event_date"
            type="datetime-local"
            {...register('event_date', { required: 'Data de início é obrigatória' })}
            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
          />
          {errors.event_date && (
            <p className="mt-1 text-sm text-red-600">{errors.event_date.message}</p>
          )}
        </div>

        <div>
          <label htmlFor="event_end_date" className="block text-sm font-medium text-gray-700 mb-1">
            Término
          </label>
          <input
            id="event_end_date"
            type="datetime-local"
            {...register('event_end_date', {
              validate: (value) => {
                if (value && eventDate && new Date(value) <= new Date(eventDate)) {
                  return 'Data de término deve ser após o início';
                }
                return true;
              }
            })}
            min={eventDate}
            className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
          />
          {errors.event_end_date && (
            <p className="mt-1 text-sm text-red-600">{errors.event_end_date.message}</p>
          )}
          <p className="mt-1 text-xs text-gray-500">
            Se não informado, será considerado 2 horas após o início
          </p>
        </div>
      </div>

      <div>
        <label htmlFor="status" className="block text-sm font-medium text-gray-700 mb-1">
          Status
        </label>
        <select
          id="status"
          {...register('status')}
          className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
        >
          {statusOptions.map((option) => (
            <option key={option.value} value={option.value}>
              {option.label}
            </option>
          ))}
        </select>
      </div>

      <div className="flex gap-3 pt-4">
        <Button type="button" variant="secondary" onClick={onCancel} className="flex-1">
          Cancelar
        </Button>
        <Button type="submit" loading={loading} className="flex-1">
          Salvar
        </Button>
      </div>
    </form>
  );
}
