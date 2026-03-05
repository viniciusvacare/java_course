package collections;

import java.util.HashSet;
import java.util.Set;

public class SetUtilizacao {
    public static void main(String[] args) {
        // Sem duplicatas - Não duplica os valores atribuidos
        // HashSet implementa Set
        Set<String> conjunto = new HashSet<>();

        conjunto.add("Java");
        conjunto.add("Java");
        conjunto.add("C#");
        conjunto.add("JavaScript");

        for (String valor : conjunto) {
            System.out.println(valor);
        }
    }
}
