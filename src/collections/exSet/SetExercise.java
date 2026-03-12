package collections.exSet;

import java.util.HashSet;
import java.util.Set;

public class SetExercise {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println(numeros.contains(1) ? "Tem 1" : "Nâo tem 1");
        System.out.println(numeros.remove(2));

        for(Integer numero : numeros) {
            System.out.println(numero);
        }
    }

}
