#!/usr/bin/env python3
"""
scan.py — Lê os arquivos .java do projeto e gera platform/data.json automaticamente.

Uso:
    python scan.py

Como documentar suas classes Java:
    Use comentários especiais no topo do arquivo para enriquecer a plataforma:

    // @title: Caixa com Generics
    // @desc: Estrutura genérica com capacidade fixa...
    // @tags: Generics, Array, OOP
    // @output:
    // [0] Maçã
    // [1] Banana

    Sem anotações, o script ainda funciona — usa o nome da classe e package.
"""

import os
import json
import re
from pathlib import Path

# ── CONFIGURAÇÃO ──────────────────────────────────────────────────────────────
SRC_DIR      = Path("src")          # pasta raiz dos seus .java
OUTPUT_FILE  = Path("platform/data.json")
WATCH_MODE   = False  # mude para True para rodar em loop contínuo (requer 'watchdog')
# ─────────────────────────────────────────────────────────────────────────────


def parse_java_file(filepath: Path) -> dict | None:
    """Extrai informações de um arquivo .java."""
    try:
        content = filepath.read_text(encoding="utf-8")
    except Exception as e:
        print(f"  ⚠ Erro ao ler {filepath}: {e}")
        return None

    # ── Package ───────────────────────────────────────────────────────────────
    pkg_match = re.search(r"^\s*package\s+([\w.]+)\s*;", content, re.MULTILINE)
    if not pkg_match:
        return None  # ignora arquivos sem package declarado
    package = pkg_match.group(1)

    # ── Nome da classe principal ──────────────────────────────────────────────
    class_match = re.search(
        r"(?:public\s+)?(?:class|interface|enum|record)\s+(\w+)", content
    )
    class_name = class_match.group(1) if class_match else filepath.stem

    # ── Anotações customizadas nos comentários ────────────────────────────────
    def extract_annotation(tag: str) -> str:
        pattern = rf"//\s*@{tag}:\s*(.+)"
        match = re.search(pattern, content, re.IGNORECASE)
        return match.group(1).strip() if match else ""

    def extract_multiline_annotation(tag: str) -> str:
        """Extrai blocos multiline como @output."""
        pattern = rf"//\s*@{tag}:(.*?)(?=//\s*@|\Z)"
        match = re.search(pattern, content, re.IGNORECASE | re.DOTALL)
        if not match:
            return ""
        lines = match.group(1).strip().splitlines()
        cleaned = [re.sub(r"^\s*//\s?", "", line) for line in lines]
        return "\n".join(cleaned).strip()

    title  = extract_annotation("title") or f"{class_name}"
    desc   = extract_annotation("desc")  or extract_annotation("description") or ""
    tags_raw = extract_annotation("tags")
    tags   = [t.strip() for t in tags_raw.split(",")] if tags_raw else infer_tags(content)
    output = extract_multiline_annotation("output")

    return {
        "pkg":         package,
        "className":   class_name,
        "title":       title,
        "description": desc,
        "tags":        tags,
        "code":        content,
        "output":      output,
        "file":        str(filepath).replace("\\", "/"),
    }


def infer_tags(content: str) -> list[str]:
    """Infere tags automaticamente baseado no conteúdo do arquivo."""
    tags = []
    patterns = {
        "Generics":    r"<[A-Z]\w*>|<T>|<E>|<K,\s*V>",
        "ArrayList":   r"\bArrayList\b",
        "HashMap":     r"\bHashMap\b",
        "LinkedList":  r"\bLinkedList\b",
        "Stack":       r"\bStack\b|\bDeque\b",
        "Queue":       r"\bQueue\b|\bPriorityQueue\b",
        "Stream API":  r"\.stream\(\)|\.filter\(|\.map\(|\.collect\(",
        "Lambda":      r"->",
        "Interface":   r"^\s*(?:public\s+)?interface\s+",
        "Abstract":    r"\babstract\b",
        "Herança":     r"\bextends\b",
        "Polimorfismo":r"@Override",
        "Enum":        r"^\s*(?:public\s+)?enum\s+",
        "Record":      r"^\s*(?:public\s+)?record\s+",
        "Exception":   r"\bthrows?\b|\bcatch\b|\bException\b",
        "Collections": r"\bCollections\b|\bList\b|\bSet\b|\bMap\b",
        "Threads":     r"\bThread\b|\bRunnable\b|\bExecutor\b",
        "OOP":         r"\bclass\b",
    }
    for tag, pattern in patterns.items():
        if re.search(pattern, content, re.MULTILINE):
            tags.append(tag)
    return tags[:5]  # máximo 5 tags inferidas


def scan(src_dir: Path) -> list[dict]:
    """Varre o diretório e coleta todos os .java."""
    results = []
    java_files = sorted(src_dir.rglob("*.java"))

    if not java_files:
        print(f"  ⚠ Nenhum arquivo .java encontrado em '{src_dir}/'")
        return results

    for filepath in java_files:
        parsed = parse_java_file(filepath)
        if parsed:
            results.append(parsed)
            print(f"  ✓ {parsed['pkg']}.{parsed['className']}")
        else:
            print(f"  ✗ Ignorado: {filepath}")

    return results


def write_output(data: list[dict], output_file: Path):
    """Salva o JSON gerado."""
    output_file.parent.mkdir(parents=True, exist_ok=True)
    with open(output_file, "w", encoding="utf-8") as f:
        json.dump(data, f, ensure_ascii=False, indent=2)
    print(f"\n✅ {len(data)} classe(s) exportada(s) → {output_file}")


def main():
    print("=" * 50)
    print("  Java Studies — Scanner")
    print("=" * 50)

    if not SRC_DIR.exists():
        print(f"\n❌ Diretório '{SRC_DIR}' não encontrado.")
        print(f"   Certifique-se de rodar este script na raiz do projeto.")
        return

    print(f"\n🔍 Escaneando '{SRC_DIR}/'...\n")
    data = scan(SRC_DIR)
    write_output(data, OUTPUT_FILE)
    print("\nAbra platform/index.html no navegador (via servidor local).")
    print("Dica: python -m http.server 8000  →  http://localhost:8000/platform/\n")


if __name__ == "__main__":
    main()