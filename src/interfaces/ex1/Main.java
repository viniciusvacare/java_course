package interfaces.ex1;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.setTipo("Carro");
        carro.iniciar();
        carro.parar();
        carro.buzinar();

        Caminhao caminhao = new Caminhao();
        caminhao.setTipo("Caminhao");
        caminhao.iniciar();
        caminhao.parar();
        caminhao.buzinar();
    }
}
