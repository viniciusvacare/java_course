package arrays;

public class Exercicio2 {
    private final int[] limitador;

    public Exercicio2(int limite) {
        this.limitador = new int[limite];
    }

    private void alimentaArray() {
        for (int i = 0; i < limitador.length; i++) {
            limitador[i] = i + 1;
        }
    }

    public int retornaSomaDosValores() {
        int soma = 0;

        alimentaArray();

        for (int i = 0; i < limitador.length; i++) {
            soma += limitador[i];
        }

        return soma;
    }
}
