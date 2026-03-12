package generics.ex1;

public class Cesto<T> {
    private T conteudo;

    public void guardar(T conteudo) {
        this.conteudo = conteudo;
    }

    public T pegar() {
        return conteudo;
    }
}
