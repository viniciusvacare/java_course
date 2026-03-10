package inputOutput.ex1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void escreverNoArquivo(String path, String content) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        writer.write(content);
        writer.close();
    }

    private static String lerArquivo(String path) throws IOException {
        StringBuilder sb = new StringBuilder();

        FileReader reader = new FileReader(path);

        int content = reader.read();

        while (content != -1) {
            sb.append((char) content);

            content = reader.read();
        }

        reader.close();

        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "src/inputOutput/ex1/GeraArquivo.txt";

        try {
            escreverNoArquivo(path, "Conteudo gerado");

            String content = lerArquivo(path);

            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
