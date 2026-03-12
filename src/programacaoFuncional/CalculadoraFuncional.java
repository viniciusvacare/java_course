package programacaoFuncional;

@FunctionalInterface
interface Calculadora {
    double calcular(double a, double b);
}

public class CalculadoraFuncional {
    public static void main(String[] args) {
        Calculadora soma = (a, b) -> a + b;
        System.out.println(soma.calcular(10, 20));

        Calculadora subtracao = (a, b) -> a - b;
        System.out.println(subtracao.calcular(30, 10));
    }
}
