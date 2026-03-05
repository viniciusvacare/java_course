package polimorfismo.ex2;

class Soma extends Operacao {
    @Override
    void tipoDaOperacao() {
        System.out.println("Soma");
    }

    @Override
    double calcular(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtracao extends Operacao {
    @Override
    void tipoDaOperacao() {
        System.out.println("Subtracao");
    }

    @Override
    double calcular(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiplicacao extends Operacao {
    @Override
    void tipoDaOperacao() {
        System.out.println("Multiplicacao");
    }

    @Override
    double calcular(double num1, double num2) {
        return num1 * num2;
    }
}

class Divisao extends Operacao {
    @Override
    void tipoDaOperacao() {
        System.out.println("Divisao");
    }

    @Override
    double calcular(double num1, double num2) {
        return num1 / num2;
    }
}

public class Calculadora {
    public static void main(String[] args) {
        Operacao soma = new Soma();
        Operacao subtracao = new Subtracao();
        Operacao multiplicacao = new Multiplicacao();
        Operacao divisao = new Divisao();

        soma.tipoDaOperacao();
        System.out.println(soma.calcular(10, 20));

        subtracao.tipoDaOperacao();
        System.out.println(subtracao.calcular(10, 20));

        multiplicacao.tipoDaOperacao();
        System.out.println(multiplicacao.calcular(10, 20));

        divisao.tipoDaOperacao();
        System.out.println(divisao.calcular(10, 20));
    }
}
