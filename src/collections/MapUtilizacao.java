package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapUtilizacao {
    public static void main(String[] args) {
        // Map é como um dicionário 

        // HashMap - sem ordem garantida (mais comum)
        Map<String, String> cpfComNome = new HashMap<>();

        // LinkedHashMap - mantém ordem de inserção
        Map<Integer, String> nomeComIdade2 = new LinkedHashMap<>();

        // TreeMap - ordenado pela chave
        Map<Integer, String> nomeComIdade3 = new TreeMap<>();

        cpfComNome.put("12312312345", "Fulano");

        System.out.println(cpfComNome.containsKey("12312312345"));
        System.out.println(cpfComNome.get("12312312345"));
    }

}
