package exceptions.ex1;

public class ExemploNullPointerExceptionInteger {
    public static void main(String[] args) {
        Integer numero = null;

        try {
            String numeroEmTexto = numero.toString();

            System.out.println(numeroEmTexto);
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
