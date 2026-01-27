package operadores;

public class Logicos {

    public Logicos(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    private final int numero1;
    private final int numero2;
    private final int VALOR = 50;

    private boolean compararSeNumerosSaoMaioresQueValor() {
        return numero1 > VALOR && numero2 > VALOR;
    }

    private boolean compararSeNumerosSaoMaioresQueValorComNot() {
        return !(numero1 > VALOR && numero2 > VALOR);
    }

    private boolean compararSeAlgumValorEhMaiorQueValor() {
        return numero1 > VALOR || numero2 > VALOR;
    }

    public String resultado() {
        String valores = numero1 + " e " + numero2 + "\n";

        String retorno = valores + (compararSeNumerosSaoMaioresQueValor() ? "Ambos > " + VALOR + "." : "Nem ambos são > " + VALOR + ".");
        retorno += "\n" + (compararSeNumerosSaoMaioresQueValorComNot() ? "Not Ambos > " + VALOR + "." : "Not Nem ambos são > " + VALOR + ".");
        retorno += "\n" + (compararSeAlgumValorEhMaiorQueValor() ? "Algum valor > " + VALOR + "." : "Nenhum valor > " + VALOR + ".");

        return retorno;
    }

}
