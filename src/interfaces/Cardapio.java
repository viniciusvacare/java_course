package interfaces;

public interface Cardapio extends Objeto {
    void exibeCardapio();
    void adicionaItem(String item);
    void removeItem(String item);
    void atualizaItem(String item);
    void exibeItem(String item);
}
