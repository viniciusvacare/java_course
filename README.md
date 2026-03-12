# Java Studies Platform

Plataforma local para organizar seus estudos de Java.

## Estrutura

```
seu-projeto/
├── src/                        ← seus arquivos .java
│   └── generics/ex2/Caixa.java
├── platform/
│   └── index.html              ← a plataforma (abrir no navegador)
├── scan.py                     ← gerador do data.json
└── README.md
```

## Como usar

### 1. Rode o scanner
Na raiz do projeto:
```bash
python scan.py
```
Isso lê todos os `.java` em `src/` e gera `platform/data.json`.

### 2. Suba um servidor local
```bash
# Python (mais simples)
cd platform
python -m http.server 8000

# Node.js
npx serve platform
```

### 3. Abra no navegador
```
http://localhost:8000
```

### 4. Fluxo de trabalho
```
Criar/editar .java  →  python scan.py  →  clicar "recarregar" na plataforma
```

---

## Documentando suas classes

Adicione comentários especiais no topo do arquivo `.java`:

```java
// @title: Nome legível do exercício
// @desc: Descrição do que o exercício demonstra
// @tags: Generics, OOP, Collections
// @output:
// linha 1 do output
// linha 2 do output

public class MinhaClasse {
  ...
}
```

**Sem anotações o scanner ainda funciona** — ele usa o nome da classe, package,
e infere as tags automaticamente pelo conteúdo (Generics, ArrayList, Lambda, etc).

---

## Tags inferidas automaticamente

O scanner detecta automaticamente:
`Generics` `ArrayList` `HashMap` `LinkedList` `Stack` `Queue`
`Stream API` `Lambda` `Interface` `Abstract` `Herança` `Polimorfismo`
`Enum` `Record` `Exception` `Collections` `Threads` `OOP`