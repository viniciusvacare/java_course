package arrays;

public class TesteDeArrays {

    public static void main(String[] args) {
        int[] numeros = new int[3];
        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;

        System.out.println(numeros[2]);
        System.out.println("Pega o ultimo valor: " + numeros[numeros.length - 1]);

        for (int numero : numeros) {
            System.out.println("Número foreach: " + numero);
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Número no for: " + numeros[i]);
        }

        Exercicio1 ex1 = new Exercicio1(3);

        ex1.exibirNotas();

        Exercicio2 ex2 = new Exercicio2(1000);

        System.out.println();
        System.out.println("Soma dos valores: " + ex2.retornaSomaDosValores());

        System.out.println();

        Exercicio3 ex3 = new Exercicio3(9);

        ex3.imprimeNumeros();
    }
}
