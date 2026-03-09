import { useState, useEffect, useCallback } from 'react';
import { useAuth } from '../hooks/useAuth';
import { useEvents } from '../hooks/useEvents';
import type { Event, EventFormData, EventFilters as EventFiltersType } from '../types/event';
import { Button } from '../components/UI/Button';
import { Modal } from '../components/UI/Modal';
import { EventList } from '../components/Events/EventList';
import { EventForm } from '../components/Events/EventForm';
import { SearchAndFilters } from '../components/Events/SearchAndFilters';

export function DashboardPage() {
  const { user, signOut } = useAuth();
  const { 
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
  } = useEvents();
  
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [editingEvent, setEditingEvent] = useState<Event | null>(null);
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [deleteConfirm, setDeleteConfirm] = useState<Event | null>(null);

  useEffect(() => {
    fetchEvents();
  }, [fetchEvents]);

  useEffect(() => {
    updateEventStatuses();
    
    const interval = setInterval(() => {
      updateEventStatuses();
    }, 60000);

    return () => clearInterval(interval);
  }, [updateEventStatuses]);

  useEffect(() => {
    fetchEvents();
  }, [filters, fetchEvents]);

  const handleFiltersChange = useCallback((newFilters: Partial<EventFiltersType>) => {
    setFilters(newFilters);
  }, [setFilters]);

  const handleOpenModal = (event?: Event) => {
    setEditingEvent(event || null);
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
    setEditingEvent(null);
  };

  const handleSubmit = async (data: EventFormData) => {
    setIsSubmitting(true);
    
    const eventData = {
      ...data,
      event_date: new Date(data.event_date).toISOString(),
      event_end_date: data.event_end_date ? new Date(data.event_end_date).toISOString() : undefined,
    };

    let result;
    if (editingEvent) {
      result = await updateEvent(editingEvent.id, eventData);
    } else {
      result = await createEvent(eventData);
    }

    setIsSubmitting(false);

    if (!result.error) {
      handleCloseModal();
      fetchEvents();
    }
  };

  const handleDeleteClick = (event: Event) => {
    setDeleteConfirm(event);
  };

  const handleConfirmDelete = async () => {
    if (!deleteConfirm) return;

    const result = await deleteEvent(deleteConfirm.id);
    
    if (!result.error) {
      setDeleteConfirm(null);
    }
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <header className="bg-white shadow-sm sticky top-0 z-40">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex items-center justify-between h-16">
            <h1 className="text-xl font-bold text-indigo-600">EventControl</h1>
            <div className="flex items-center gap-4">
              <span className="text-sm text-gray-600 hidden sm:block">
                {user?.email}
              </span>
              <Button variant="ghost" size="sm" onClick={signOut}>
                Sair
              </Button>
            </div>
          </div>
        </div>
      </header>

      <main className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4 mb-6">
          <h2 className="text-2xl font-bold text-gray-900">Meus Eventos</h2>
          <Button onClick={() => handleOpenModal()}>
            + Novo Evento
          </Button>
        </div>

        <SearchAndFilters 
          filters={filters} 
          onFiltersChange={handleFiltersChange}
          totalResults={pagination.total}
        />

        {error && (
          <div className="mb-6 p-4 bg-red-50 border border-red-200 rounded-lg">
            <p className="text-sm text-red-600">{error}</p>
          </div>
        )}

        <EventList
          events={events}
          loading={loading}
          loadingMore={loadingMore}
          hasMore={pagination.hasMore}
          onEdit={handleOpenModal}
          onDelete={handleDeleteClick}
          onLoadMore={loadMore}
        />
      </main>

      <Modal
        isOpen={isModalOpen}
        onClose={handleCloseModal}
        title={editingEvent ? 'Editar Evento' : 'Novo Evento'}
      >
        <EventForm
          event={editingEvent}
          onSubmit={handleSubmit}
          onCancel={handleCloseModal}
          loading={isSubmitting}
        />
      </Modal>

      <Modal
        isOpen={!!deleteConfirm}
        onClose={() => setDeleteConfirm(null)}
        title="Confirmar exclusão"
      >
        <div className="space-y-4">
          <p className="text-gray-600">
            Tem certeza que deseja excluir o evento <strong>"{deleteConfirm?.title}"</strong>?
            Esta ação não pode ser desfeita.
          </p>
          <div className="flex gap-3">
            <Button
              variant="secondary"
              onClick={() => setDeleteConfirm(null)}
              className="flex-1"
            >
              Cancelar
            </Button>
            <Button
              variant="danger"
              onClick={handleConfirmDelete}
              loading={loading}
              className="flex-1"
            >
              Excluir
            </Button>
          </div>
        </div>
      </Modal>
    </div>
  );
}
