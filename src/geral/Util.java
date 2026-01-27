package geral;

import java.text.Normalizer;

public abstract class Util {
    public static String removerAcentos(String texto) {
        if (texto == null) return null;
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
