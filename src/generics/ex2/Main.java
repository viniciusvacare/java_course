package generics.ex2;

public class Main {
    public static void main(String[] args) {
        Caixa<String> caixa = new Caixa<>(3);
        caixa.adicionar("Maçã", 0);
        caixa.adicionar("Banana", 1);
        caixa.adicionar("Laranja", 2);

        System.out.println(caixa.obter(1));
    }
}
