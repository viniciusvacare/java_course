package lambdaExpression.ex1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Impar {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 99, 101, 102, 109));

        // Remove números impares
        numeros.removeIf(numero -> numero % 2 != 0);

        System.out.println(numeros);
    }
}
