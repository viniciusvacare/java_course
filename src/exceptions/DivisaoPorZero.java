package exceptions;

public class DivisaoPorZero {
    public static void main(String[] args) {
        int totalNotal = 0;
        int quantidadeAluno = 0;

        try {
            int resultado = totalNotal / quantidadeAluno;

            System.out.println(resultado);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
