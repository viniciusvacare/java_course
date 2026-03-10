package serialization;

import java.io.Serializable;

public class Contato implements Serializable {
    public String nome;
    public String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

}
