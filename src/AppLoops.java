import java.util.Scanner;

public class AppLoops {
    private static void testeForLoop(int quantidade) {
        for (int i = 0; i <= quantidade; i++) {
            System.out.println("Loop FOR: " + i);
        }
    }

    private static void testeWhileLoop(int quantidade) {
        int i = 0;
        while (i < quantidade) {
            System.out.println("Loop WHILE: " + i);
            i++;
        }
    }

    private static void testeWhileLoop() {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.print("Deseja continuar?");
            String continuar = teclado.next();
            if (!continuar.equals("sim")) {
                break;
            }
        }
        teclado.close();
    }

    private static void testeDoWhileLoop() {
        int valor = 0;
        do {
            System.out.println("Vai começar essa merda de Do While " + valor);

            valor++;

        } while (valor != 10);
    }

    // Exercício Loop for: Soma de Valores Acumulados
    private static int somaDosValoresAcumulados(int ateQuantoAcumular) {
        int valorFinal = 0;
        
        for (int i = 0; i < ateQuantoAcumular; i++) {
            valorFinal += i;
        }

        return valorFinal;
    }

    public static void main(String[] args) {
        int quantidadeLoops = 5;
        //testeForLoop(quantidadeLoops);
//        testeWhileLoop(10);
//        testeDoWhileLoop();

        int exercicio1 = somaDosValoresAcumulados(quantidadeLoops);

        System.out.println(exercicio1);
    }
}