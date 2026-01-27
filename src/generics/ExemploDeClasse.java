package generics;

import java.util.List;

class Caixa<T> {
    private T conteudo;

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }
}

public class ExemploDeClasse {
    public static void main(String[] args) {
        Caixa<Integer> caixaDeNumero = new Caixa<>();
        caixaDeNumero.setConteudo(100);
        System.out.println(caixaDeNumero.getConteudo());

        Caixa<String> caixaDeTexto = new Caixa<>();
        caixaDeTexto.setConteudo("Texto");
        System.out.println(caixaDeTexto.getConteudo());
    }
}
