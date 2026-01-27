package operadores;

public class Unarios {
    private int valor = 0;

    public void preIncremento() {
        ++valor;
    }

    public void posIncremento() {
        valor++;
    }

    public void preDecremento() {
        --valor;
    }

    public void posDecremento() {
        valor--;
    }

    public void retornaValor() {
        System.out.println("Valor atual: " + valor);
    }
}
