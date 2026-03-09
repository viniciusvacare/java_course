import { useState, useEffect, useCallback } from 'react';
import type { EventFilters, EventStatus, SortField } from '../../types/event';
import { Button } from '../UI/Button';

interface SearchAndFiltersProps {
  filters: EventFilters;
  onFiltersChange: (filters: Partial<EventFilters>) => void;
  totalResults: number;
}

const statusOptions: { value: EventStatus | 'all'; label: string }[] = [
  { value: 'all', label: 'Todos os status' },
  { value: 'upcoming', label: 'Agendados' },
  { value: 'ongoing', label: 'Em andamento' },
  { value: 'finished', label: 'Finalizados' },
  { value: 'cancelled', label: 'Cancelados' },
];

const sortOptions: { value: SortField; label: string }[] = [
  { value: 'event_date', label: 'Data do evento' },
  { value: 'title', label: 'Título' },
  { value: 'status', label: 'Status' },
  { value: 'created_at', label: 'Data de criação' },
];

export function SearchAndFilters({ filters, onFiltersChange, totalResults }: SearchAndFiltersProps) {
  const [searchInput, setSearchInput] = useState(filters.search);
  const [showAdvanced, setShowAdvanced] = useState(false);

  useEffect(() => {
    const timer = setTimeout(() => {
      if (searchInput !== filters.search) {
        onFiltersChange({ search: searchInput });
      }
    }, 300);

    return () => clearTimeout(timer);
  }, [searchInput, filters.search, onFiltersChange]);

  const handleStatusChange = useCallback((status: EventStatus | 'all') => {
    onFiltersChange({ status });
  }, [onFiltersChange]);

  const handleSortChange = useCallback((sortField: SortField) => {
    onFiltersChange({ sortField });
  }, [onFiltersChange]);

  const handleSortOrderToggle = useCallback(() => {
    onFiltersChange({ sortOrder: filters.sortOrder === 'asc' ? 'desc' : 'asc' });
  }, [filters.sortOrder, onFiltersChange]);

  const handleDateFromChange = useCallback((dateFrom: string) => {
    onFiltersChange({ dateFrom });
  }, [onFiltersChange]);

  const handleDateToChange = useCallback((dateTo: string) => {
    onFiltersChange({ dateTo });
  }, [onFiltersChange]);

  const handleClearFilters = useCallback(() => {
    setSearchInput('');
    onFiltersChange({
      status: 'all',
      search: '',
      dateFrom: '',
      dateTo: '',
      sortField: 'event_date',
      sortOrder: 'asc',
    });
  }, [onFiltersChange]);

  const hasActiveFilters = filters.search || filters.status !== 'all' || filters.dateFrom || filters.dateTo;

  return (
    <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4 mb-6">
      <div className="flex flex-col lg:flex-row gap-4">
        <div className="flex-1">
          <div className="relative">
            <input
              type="text"
              placeholder="Buscar por título ou descrição..."
              value={searchInput}
              onChange={(e) => setSearchInput(e.target.value)}
              className="w-full pl-10 pr-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
            />
            <svg
              className="absolute left-3 top-1/2 -translate-y-1/2 w-5 h-5 text-gray-400"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"
              />
            </svg>
          </div>
        </div>

        <div className="flex flex-wrap gap-2">
          <select
            value={filters.status}
            onChange={(e) => handleStatusChange(e.target.value as EventStatus | 'all')}
            className="px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors bg-white"
          >
            {statusOptions.map((option) => (
              <option key={option.value} value={option.value}>
                {option.label}
              </option>
            ))}
          </select>

          <div className="flex items-center gap-1">
            <select
              value={filters.sortField}
              onChange={(e) => handleSortChange(e.target.value as SortField)}
              className="px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors bg-white"
            >
              {sortOptions.map((option) => (
                <option key={option.value} value={option.value}>
                  {option.label}
                </option>
              ))}
            </select>
            <button
              onClick={handleSortOrderToggle}
              className="p-2 border border-gray-300 rounded-lg hover:bg-gray-50 transition-colors"
              title={filters.sortOrder === 'asc' ? 'Ordem crescente' : 'Ordem decrescente'}
            >
              {filters.sortOrder === 'asc' ? (
                <svg className="w-5 h-5 text-gray-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 4h13M3 8h9m-9 4h6m4 0l4-4m0 0l4 4m-4-4v12" />
                </svg>
              ) : (
                <svg className="w-5 h-5 text-gray-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 4h13M3 8h9m-9 4h9m5-4v12m0 0l-4-4m4 4l4-4" />
                </svg>
              )}
            </button>
          </div>

          <button
            onClick={() => setShowAdvanced(!showAdvanced)}
            className={`px-3 py-2 border rounded-lg transition-colors ${
              showAdvanced || filters.dateFrom || filters.dateTo
                ? 'border-indigo-500 bg-indigo-50 text-indigo-600'
                : 'border-gray-300 hover:bg-gray-50 text-gray-600'
            }`}
          >
            <svg className="w-5 h-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 4a1 1 0 011-1h16a1 1 0 011 1v2.586a1 1 0 01-.293.707l-6.414 6.414a1 1 0 00-.293.707V17l-4 4v-6.586a1 1 0 00-.293-.707L3.293 7.293A1 1 0 013 6.586V4z" />
            </svg>
          </button>
        </div>
      </div>

      {showAdvanced && (
        <div className="mt-4 pt-4 border-t border-gray-200">
          <div className="flex flex-col sm:flex-row gap-4">
            <div className="flex-1">
              <label className="block text-sm font-medium text-gray-700 mb-1">
                Data inicial
              </label>
              <input
                type="date"
                value={filters.dateFrom}
                onChange={(e) => handleDateFromChange(e.target.value)}
                className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
              />
            </div>
            <div className="flex-1">
              <label className="block text-sm font-medium text-gray-700 mb-1">
                Data final
              </label>
              <input
                type="date"
                value={filters.dateTo}
                onChange={(e) => handleDateToChange(e.target.value)}
                className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:border-indigo-500 outline-none transition-colors"
              />
            </div>
          </div>
        </div>
      )}

      <div className="mt-4 flex items-center justify-between">
        <p className="text-sm text-gray-500">
          {totalResults} {totalResults === 1 ? 'evento encontrado' : 'eventos encontrados'}
        </p>
        {hasActiveFilters && (
          <Button variant="ghost" size="sm" onClick={handleClearFilters}>
            Limpar filtros
          </Button>
        )}
      </div>
    </div>
  );
}
