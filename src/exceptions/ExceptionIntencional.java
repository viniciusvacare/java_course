package exceptions;

public class ExceptionIntencional {
    public static void main(String[] args) {
        int idade = 16;

        if(idade < 18) {
            throw new RuntimeException("Sem permissão: Menor de idade");
        }

        System.out.println("Executou");
    }

}
