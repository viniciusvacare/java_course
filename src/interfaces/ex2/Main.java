package interfaces.ex2;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.adicionarItem("Pizza", 25.0);
        pedido.adicionarItem("Bebida", 5.0);
        pedido.adicionarItem("Batata Frita", 15.0);
        pedido.adicionarItem("Sobremesa", 10.0);
        System.out.println("Total: " + pedido.calcularTotal());
    }
}
