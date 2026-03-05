package polimorfismo.ex1;

import java.util.List;

public class GerenciadorVeiculo {
    public static void main(String[] args) {
        Veiculo[] veiculos = new Veiculo[2];
        veiculos[0] = new Onibus("ABC123", 2022, 40);
        veiculos[1] = new Caminhao("DEF456", 2021, 6);

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirInformacoes();
            System.out.println();
        }
    }
}
