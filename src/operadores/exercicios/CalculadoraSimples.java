package operadores.exercicios;

public class CalculadoraSimples {
    public double a, b;

    public void retornaValores() {
        System.out.println("Soma de a e b: " + (a + b));
        System.out.println("Subtração de a por b: " + (a - b));
        System.out.println("Multiplicação de a por b: " + (a * b));
        System.out.println("Divisão de a por b: " + (a / b));
        System.out.println("Resto da divisão entre a e b: " + (a % b));
    }
}
