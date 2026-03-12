package lambdaExpression.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManipularListas {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>(Arrays.asList("banana", "maçã", "melancia", "goiaba"));

        lista.removeIf(nome -> nome.length() > 5);

        lista.add(0, "abacate");

        lista.forEach(System.out::println);
    }
}
