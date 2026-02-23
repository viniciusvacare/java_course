package interfaces.ex3;

public class Main {
    public static void main(String[] args) {
        ProdutoImpl produto = new ProdutoImpl("Produto 1", 10);
        produto.adicionarQuantidade(5);
        produto.removerQuantidade(30);
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Quantidade: " + produto.getQuantidade());
    }
}
