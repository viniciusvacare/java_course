package annotations;

public class ExemploHeranca {
    private final String nome;

    public ExemploHeranca(String nome) {
        this.nome = nome;
    }

    public void retornaMensagem() {
        System.out.println("eai " + this.nome);
    }

    public String getNome() {
        return this.nome.toUpperCase();
    }
}
