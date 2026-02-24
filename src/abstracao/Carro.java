package abstracao;

public abstract class Carro {
    private String modelo;
    public abstract void acelerar();
    public abstract void frear();

    public Carro(String modelo) {
        this.modelo = modelo;
    }

    public void ligar() {
        System.out.println("Carro de modelo " + this.modelo + " ligado");
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }
}
