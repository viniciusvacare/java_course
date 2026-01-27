package fundamentos;

import geral.Util;

public class ControleEstoquePadaria {
    public ControleEstoquePadaria(int quantidadeFarinha, int quantidadeAcucar) {
        this.quantidadeFarinha = quantidadeFarinha;
        this.quantidadeAcucar = quantidadeAcucar;
    }

    int quantidadeFarinha;
    int quantidadeAcucar;

    public void setQuantidadeFarinha(int quantidadeFarinha) {
        this.quantidadeFarinha = quantidadeFarinha;
    }

    public void setQuantidadeAcucar(int quantidadeAcucar) {
        this.quantidadeAcucar = quantidadeAcucar;
    }

    public int getQuantidadeFarinha() {
        return quantidadeFarinha;
    }

    public int getQuantidadeAcucar() {
        return quantidadeAcucar;
    }

    public void adicionarAoEstoque(String tipo, int quantidade) {
        if (Util.removerAcentos(tipo).equalsIgnoreCase("farinha")) {
            this.quantidadeFarinha += quantidade;
        } else if (Util.removerAcentos(tipo).equalsIgnoreCase("acucar")) {
            this.quantidadeAcucar += quantidade;
        }
    }

    public void adicionarAoEstoque(int quantidade) {
        this.quantidadeFarinha += quantidade;
        this.quantidadeAcucar += quantidade;
    }

    public void exibeQuantidade() {
        System.out.println("Quantidade de Farinha: " + getQuantidadeFarinha());
        System.out.println("Quantidade de Açucar: " + getQuantidadeAcucar());
        System.out.println("-----------------------------------");
    }
}
