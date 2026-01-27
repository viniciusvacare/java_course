package arrays;

public class Exercicio3 {
    private final int[] limitador;

    public Exercicio3(int limite) {
        this.limitador = new int[limite + 1];
    }

    private void alimentaArray() {
        for (int i = 0; i < limitador.length; i++) {
            limitador[i] = i;
        }
    }

    private int[] retornaNumeroPar() {
        alimentaArray();

        int contador = 0;
        for (int i = 0; i < limitador.length; i++) {
            if (limitador[i] % 2 == 0) {
                contador++;
            }
        }

        int[] numeroPar = new int[contador];
        int index = 0;

        for (int i = 0; i < limitador.length; i++) {
            if (limitador[i] % 2 == 0) {
                numeroPar[index] = limitador[i];
                index++;
            }
        }

        return numeroPar;
    }

    public void imprimeNumeros () {
        int[] numeros = new int[retornaNumeroPar().length];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = retornaNumeroPar()[i];
        }

        for (int numero : numeros) {
            System.out.println("Numero >>> " + numero);
        }
    }
}
