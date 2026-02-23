package interfaces;

public class App {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        restaurante.exibeCardapio();
        restaurante.adicionaItem("Pizza");
        restaurante.removeItem("Pizza");
        restaurante.atualizaItem("Pizza");
        restaurante.exibeItem("Pizza");
        restaurante.exibeObjeto();

        restaurante.exibeObjetoComDefault();
        Objeto.exibeObjetoComStatic();
    }
}
