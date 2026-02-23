package abstracao;

public class CarroDeCorrida extends Carro {
    public CarroDeCorrida(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("Carro " + this.getModelo() + " acelerando");
    }

    @Override
    public void frear() {
        System.out.println("Carro " + this.getModelo() + " freando");
    }
}
