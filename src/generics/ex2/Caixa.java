package generics.ex2;

public class Caixa<T> {
    private T[] elementos;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public Caixa(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = (T[]) new Object[capacidade];
    }

    public void adicionar(T elemento, int indice) {
        if (indice < 0 || indice >= capacidade) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fora dos limites. Capacidade: " + capacidade);
        }
        elementos[indice] = elemento;
    }

    public T obter(int indice) {
        if (indice < 0 || indice >= capacidade) {
            throw new IndexOutOfBoundsException("Índice " + indice + " fora dos limites. Capacidade: " + capacidade);
        }
        return elementos[indice];
    }

    public int getCapacidade() {
        return capacidade;
    }
}
