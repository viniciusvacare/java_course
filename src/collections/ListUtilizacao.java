package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtilizacao {
    public static void main(String[] args) {
        // Coleção ordenada
        // Pode conter duplicada

        // ArrayList - acesso por índice rápido (mais comum)
        List<String> nomes = new ArrayList<>();

        // LinkedList - inserção/remoção no meio mais eficiente
        // List<String> nomes = new LinkedList<>();

        nomes.add("Fulano");
        nomes.add("Beltrano");
        nomes.add("Ciclano");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        List<String> outrosNomes = Arrays.asList("Teste 1", "Teste 2");
        nomes.addAll(outrosNomes);

        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println(nomes.size());
        System.out.println(nomes.get(2));
    }

}
