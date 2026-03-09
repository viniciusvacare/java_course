package exceptions;

public class LimiteArray {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4 };

        try {
            int numero = numeros[5];
            System.out.println(numero);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
