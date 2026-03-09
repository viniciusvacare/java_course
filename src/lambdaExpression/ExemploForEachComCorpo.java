package lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploForEachComCorpo {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> numerosPares = new ArrayList<>();

        // Não precisa usar Integer por conta da inferencia
        numeros.forEach(numero -> {if (numero % 2 == 0) numerosPares.add(numero);});

        System.out.println(numerosPares);
    }
}
