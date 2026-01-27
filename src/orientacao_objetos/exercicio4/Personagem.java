package orientacao_objetos.exercicio4;

public class Personagem {
    private String nome;
    private Integer nivelDePoder;

    public Personagem(String consNome, Integer consNivelDePoder) {
        this.nome = consNome;
        this.nivelDePoder = consNivelDePoder;
    }

    public void tentarAumentarNivelDePoder(int nivel) {
        this.nivelDePoder += nivel;
    }

    public void alterarNome(Personagem personagem) {
        this.nome = personagem.nome;
    }

    public void dadosAtuais() {
        System.out.println(this.nome + " e " + this.nivelDePoder + " de poder atual");
    }
}
