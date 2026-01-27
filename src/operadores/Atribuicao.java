package operadores;

public class Atribuicao {
    private Double valor;

    public void setValor(double valorParametro) {
        this.valor = valorParametro;
    }

    public void adicionarValor(double quantidade) {
        this.erro();
        this.valor += quantidade;
    }

    public void subtrairValor(double quantidade) {
        this.valor -= quantidade;
    }

    public void dividirValor(double quantidade) {
        this.valor /= quantidade;
    }

    public void multiplicarValor(double quantidade) {
        this.valor *= quantidade;
    }

    public void restoValor(double quantidade) {
        this.valor %= quantidade;
    }

    public void mostrarValorAtual() {
        System.out.println("Valor atual: " + this.valor);
    }

    public void resetarValorInicial() {
        double VALOR_INICIAL = 100;
        this.valor = VALOR_INICIAL;
    }

    private void erro() {
        if (this.valor == null) {
            throw new IllegalStateException("O valor não foi definido!");
        }
    }
}
