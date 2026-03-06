package collections.exMap;

import java.util.Map;
import java.util.HashMap;

public class MapExercise {
    public static Integer remover(Integer quantidade, Integer quantidadeAtual) {
        return quantidadeAtual - quantidade >= 0 ? quantidadeAtual - quantidade : quantidadeAtual;
    }

    public static Integer adicionar(Integer quantidade, Integer quantidadeAtual) {
        return quantidadeAtual + quantidade;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> estoque = new HashMap<>();

        estoque.put(1, 20);
        estoque.put(2, 2);
        estoque.put(3, 55);
        estoque.put(4, 8);
        estoque.put(5, 15);

        System.out.println("Estoque do produto 1: " + estoque.get(1));

        estoque.put(1, remover(12, estoque.get(1)));
        estoque.put(1, remover(12, estoque.get(1)));
        estoque.put(1, adicionar(35, estoque.get(1)));

        System.out.println("Novo estoque do produto 1: " + estoque.get(1));
    }
}
