package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUtilizacao {
    public static void main(String[] args) {
        // Sem duplicatas - Não duplica os valores atribuidos
        // Não tem ordenação
        // HashSet implementa Set

        // HashSet - sem ordem garantida (mais comum)
        Set<String> conjunto = new HashSet<>();

        // LinkedHashSet - mantém ordem de inserção
        // Set<String> nomes = new LinkedHashSet<>();

        // TreeSet - ordenado alfabeticamente
        // Set<String> nomes = new TreeSet<>();

        conjunto.add("Java");
        conjunto.add("Java");
        conjunto.add("Python");
        conjunto.add("C#");
        conjunto.add("JavaScript");

        for (String valor : conjunto) {
            System.out.println(valor);
        }

        Object elementoRemovido = conjunto.remove("Java");
        System.out.println(elementoRemovido);

        boolean foiAdicionado = conjunto.add("JavaScript");
        System.out.println(foiAdicionado ? "JavaScript foi adicionado" : "JavaScript não foi adicionado");

        conjunto.clear();
        System.out.println(conjunto);
    }
}
