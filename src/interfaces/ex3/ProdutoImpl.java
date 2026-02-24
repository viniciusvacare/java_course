package interfaces.ex3;

public class ProdutoImpl implements Produto {
    String nome;
    int quantidade;

    public ProdutoImpl(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        if (this.quantidade - quantidade < 0) {
            throw new RuntimeException("Quantidade insuficiente");
        }
        this.quantidade -= quantidade;
    }

    public String getNome() {
        return this.nome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
}

