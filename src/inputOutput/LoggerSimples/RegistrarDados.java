package inputOutput.LoggerSimples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RegistrarDados {
    private static void registrar(int id, String nome) {
        String fileName = "./src/inputOutput/LoggerSimples/dados_registrados.txt";

        try {
            FileWriter writer = new FileWriter(fileName, true);

            writer.write("Data de registro: " + LocalDateTime.now() + " " +
                         "ID: " + id + " " +
                         "Nome: " + nome.toUpperCase() + 
                         "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        registrar(1, "Teste 1");
        registrar(2, "Teste 2");
        registrar(3, "Teste 3");
    }

}
