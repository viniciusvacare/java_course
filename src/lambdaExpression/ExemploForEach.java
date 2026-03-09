package lambdaExpression;

import java.util.Arrays;
import java.util.List;

public class ExemploForEach {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        for (Integer numero : numeros) {
            System.out.println("ForEach normal: " + numero);
        }

        // Não precisa usar Integer por conta da inferencia
        numeros.forEach((numero) -> System.out.println("ForEach lambda: " + numero));
    }
}
