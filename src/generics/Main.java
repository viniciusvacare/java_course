package generics;

public class Main {
    public static void main(String[] args) {
        CaixaDeCoisas<String> caixaDeTexto = new CaixaDeCoisas<>();
        caixaDeTexto.setConteudo("Texto");
        System.out.println(caixaDeTexto.getConteudo());

        CaixaDeCoisas<Integer> caixaDeNumero = new CaixaDeCoisas<>();
        caixaDeNumero.setConteudo(10);
        System.out.println(caixaDeNumero.getConteudo());

        System.out.println(caixaDeTexto.getClass().getName());
    }
}
