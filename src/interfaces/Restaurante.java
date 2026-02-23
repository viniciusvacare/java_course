package interfaces;

public class Restaurante implements Cardapio {
    @Override
    public void exibeCardapio() {
        System.out.println("Exibindo cardapio");
    }

    @Override
    public void adicionaItem(String item) {
        System.out.println("Adicionando item: " + item);
    }

    @Override
    public void removeItem(String item) {
        System.out.println("Removendo item: " + item);
    }

    @Override
    public void atualizaItem(String item) {
        System.out.println("Atualizando item: " + item);
    }

    @Override
    public void exibeItem(String item) {
        System.out.println("Exibindo item: " + item);
    }

    @Override
    public void exibeObjeto() {
        System.out.println("Exibindo objeto");
    }
}
