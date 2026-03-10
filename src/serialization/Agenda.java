package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    public static void main(String[] args) {
        List<Contato> listaDeContatos = new ArrayList<>();

        listaDeContatos.add(new Contato("Fulano", "18293828329"));
        listaDeContatos.add(new Contato("Beltrano", "192832983838"));

        listaDeContatos.forEach(contato -> System.out.println("Contato: " + contato.nome + " | Telefone: " + contato.telefone));

        try {
            // Serialization (Salvar dados em um arquivo)
            FileOutputStream outputStream = new FileOutputStream("./src/serialization/arquivos/dados.ser");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(listaDeContatos);

            objectOutputStream.close();

            // Deserialization (Ler arquivo)
            FileInputStream inputStream = new FileInputStream("./src/serialization/arquivos/dados.ser");

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            List<Contato> contatoLido = (List<Contato>) objectInputStream.readObject();

            objectInputStream.close();

            System.out.println(contatoLido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
