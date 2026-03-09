package exceptions;

public class DivisaoPorZeroLancandoException {
    private static int calcularMedia(int totalNotas, int totalAlunos) throws ArithmeticException {
        return totalNotas / totalAlunos;
    }

    public static void main(String[] args) {
        try {
            int media = calcularMedia(10, 0);

            System.out.println(media);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        
    }

}
