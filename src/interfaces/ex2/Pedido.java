package interfaces.ex2;

import java.util.HashMap;
import java.util.Map;

public class Pedido implements PedidoRestaurante {
    Map<String, Double> itens = new HashMap<>();

    @Override
    public void adicionarItem(String item, double preco) {
        this.itens.put(item, preco);
        System.out.println("Item adicionado: " + item + " - R$ " + preco);
    }

    @Override
    public double calcularTotal() {
        double valorTotal = 0;

        for (Map.Entry<String, Double> entry : this.itens.entrySet()) {
            valorTotal += entry.getValue();
        }

        return valorTotal;
    }
}
