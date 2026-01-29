package heranca;

public class Exercicio1 {
    public static void main(String[] args) {
        Carro c1 = new Carro();

        c1.acelerar();
    }
}

class Veiculo {
    public void acelerar() {
        System.out.println("Veiculo acelerando");
    }
}

class Carro extends Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Carro acelerando");
        super.acelerar();
    }
}