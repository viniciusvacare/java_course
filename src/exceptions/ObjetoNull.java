package exceptions;

public class ObjetoNull {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        // Dispara exception quando tenta acessar um objeto null

        String nome = null;

        try {
            int tamanhoNome = nome.length();

            System.out.println(tamanhoNome);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("Final");
        }
    }
}
