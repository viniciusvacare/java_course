# EventControl - Sistema MVP de Controle de Eventos

Sistema de gerenciamento de eventos construído com React, TypeScript, Tailwind CSS e Supabase.

## Stack Tecnológica

- **React 18** + **TypeScript** - Framework frontend
- **Tailwind CSS** - Estilização
- **Supabase** - Autenticação + Banco de dados PostgreSQL
- **React Hook Form** - Gerenciamento de formulários
- **date-fns** - Formatação de datas
- **React Router DOM** - Roteamento

## Pré-requisitos

- Node.js 20.19+ ou 22.12+
- Conta no [Supabase](https://supabase.com)

## Configuração do Supabase

### 1. Criar projeto no Supabase

Acesse [supabase.com](https://supabase.com) e crie um novo projeto.

### 2. Criar tabela de eventos

No SQL Editor do Supabase, execute o seguinte script:

```sql
CREATE TABLE events (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  location VARCHAR(255),
  event_date TIMESTAMP WITH TIME ZONE NOT NULL,
  event_end_date TIMESTAMP WITH TIME ZONE,
  status VARCHAR(20) DEFAULT 'upcoming' CHECK (status IN ('upcoming', 'ongoing', 'finished', 'cancelled')),
  created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
  user_id UUID REFERENCES auth.users(id) ON DELETE CASCADE
);

ALTER TABLE events ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Users can manage their own events"
ON events FOR ALL
USING (auth.uid() = user_id);
```

### 2.1 Migração (se já tiver a tabela criada)

Se você já tem a tabela `events` criada, execute apenas:

```sql
ALTER TABLE events ADD COLUMN IF NOT EXISTS event_end_date TIMESTAMP WITH TIME ZONE;
```

### 3. Configurar variáveis de ambiente

Copie o arquivo `.env.example` para `.env` e preencha com suas credenciais do Supabase:

```bash
cp .env.example .env
```

Edite o arquivo `.env`:

```env
VITE_SUPABASE_URL=https://seu-projeto.supabase.co
VITE_SUPABASE_ANON_KEY=sua_anon_key_aqui
```

Você encontra essas informações em: **Project Settings > API** no painel do Supabase.

## Instalação

```bash
# Instalar dependências
npm install

# Iniciar servidor de desenvolvimento
npm run dev

# Build para produção
npm run build
```

## Funcionalidades

### Autenticação
- Login com e-mail e senha
- Cadastro de novos usuários
- Logout
- Rotas protegidas (redirecionamento automático para login)

### CRUD de Eventos
- Listar todos os eventos do usuário logado
- Criar novo evento via modal
- Editar evento existente
- Excluir evento com confirmação

### Busca e Filtros
- **Busca por texto** - Pesquisa por título ou descrição
- **Filtro por status** - upcoming, ongoing, finished, cancelled
- **Filtro por intervalo de datas** - Data inicial e final
- **Ordenação** - Por data do evento, título, status ou data de criação
- **Ordem** - Crescente ou decrescente

### Paginação
- **Infinite scroll** - Carrega mais eventos automaticamente ao rolar a página
- 12 eventos por página

### Atualização Automática de Status
- Eventos mudam automaticamente de "upcoming" para "ongoing" quando a data/hora chega
- Eventos mudam de "ongoing" para "finished" após o término
- Verificação a cada 60 segundos

### Status de Eventos
- **Agendado** (upcoming) - Badge azul
- **Em andamento** (ongoing) - Badge verde
- **Finalizado** (finished) - Badge cinza
- **Cancelado** (cancelled) - Badge vermelho

## Estrutura do Projeto

```
src/
├── components/
│   ├── Auth/
│   │   └── LoginForm.tsx         # Formulário de login/cadastro
│   ├── Events/
│   │   ├── EventCard.tsx         # Card individual do evento
│   │   ├── EventForm.tsx         # Formulário de criação/edição
│   │   ├── EventList.tsx         # Grid de eventos com infinite scroll
│   │   └── SearchAndFilters.tsx  # Busca, filtros e ordenação
│   └── UI/
│       ├── Modal.tsx             # Componente modal
│       ├── Button.tsx            # Botão reutilizável
│       └── Badge.tsx             # Badge de status
├── hooks/
│   ├── useAuth.ts                # Hook de autenticação
│   └── useEvents.ts              # Hook de CRUD de eventos com filtros
├── lib/
│   └── supabase.ts               # Cliente Supabase
├── types/
│   └── event.ts                  # Tipos TypeScript
├── pages/
│   ├── LoginPage.tsx             # Página de login
│   └── DashboardPage.tsx         # Dashboard principal
├── App.tsx                       # Componente principal com rotas
├── main.tsx                      # Entry point
└── index.css                     # Estilos globais (Tailwind)
```

## Scripts Disponíveis

- `npm run dev` - Inicia o servidor de desenvolvimento
- `npm run build` - Gera build de produção
- `npm run preview` - Visualiza o build de produção
- `npm run lint` - Executa o linter

## Design

- **Tema:** Light mode com acentos em indigo-600
- **Fundo:** gray-50
- **Cards:** Sombra suave com hover effect
- **Layout responsivo:** 1 coluna (mobile), 2 colunas (tablet), 3 colunas (desktop)
- **Header fixo:** Permanece visível durante o scroll

## Licença

MIT
