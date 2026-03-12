package inputOutput.ImplementarJavaIO;

import java.io.FileReader;
import java.io.FileWriter;

public class GeraArquivo {
    public static void main(String[] args) {
        String fileName = "./src/inputOutput/implementarJavaIO/arquivo_gerado.txt";
        
        try {
            // Manipulação de arquivo
            FileWriter fw = new FileWriter(fileName);
            fw.write("Testando");
            fw.close();

            // Ler arquivo
            FileReader fr = new FileReader(fileName);
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data + " ");
                data = fr.read();
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
