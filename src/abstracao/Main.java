package abstracao;

public class Main {
    public static void main(String[] args) {
        CarroDeCorrida carroDeCorrida = new CarroDeCorrida("Ferrari");
        carroDeCorrida.ligar();
        carroDeCorrida.acelerar();
        carroDeCorrida.frear();
    }
}
