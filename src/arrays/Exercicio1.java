package arrays;

import java.util.Random;

public class Exercicio1 {
    private final double[] notas;

    public Exercicio1(int tamanho) {
        this.notas = new double[tamanho];
    }

    private void geraNotasAleatorias() {
        Random random = new Random();
        for (int i = 0; i < notas.length; i++) {
            notas[i] = random.nextDouble() * 10;
        }
    }

    public void exibirNotas() {
        geraNotasAleatorias();
        for (int i = 0; i < notas.length; i++) {
            double notaArredondada = Math.ceil(notas[i] * 100) / 100;

            if (i == notas.length - 1) {
                System.out.print("Nota " + (i + 1) + "[" + notaArredondada + "]");
                break;
            }

            System.out.print("Nota " + (i + 1) + "[" + notaArredondada + "], ");
        }
    }
}
