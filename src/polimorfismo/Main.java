package polimorfismo;

public class Main {
    public static void main(String[] args) {
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        cachorro.emitirSom();
        gato.emitirSom();

        cachorro.dormir();
        gato.dormir();

        Veiculo carro = new Carro();
        carro.acelerar();
        carro.frear();

    }
}
