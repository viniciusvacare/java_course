package interfaces.ex1;

public class Carro implements Veiculo {
    private String tipo;

    @Override
    public void iniciar() {
        System.out.println(this.tipo + " iniciando");
    }

    @Override
    public void parar() {
        System.out.println(this.tipo + " parando");
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void buzinar() {
        System.out.println(this.tipo + " buzinando");
    }
}
