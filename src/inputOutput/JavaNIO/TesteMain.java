package inputOutput.JavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteMain {
    public static void main(String[] args) {
        Path file = Paths.get("./src/inputOutput/LoggerSimples/dados_registrados.txt");

        try {
            // Escreve no arquivo
            Files.write(file, "Inserindo outro valor".getBytes());

            // Ler arquivo
            byte[] bytes = Files.readAllBytes(file);

            String content = new String(bytes);

            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
