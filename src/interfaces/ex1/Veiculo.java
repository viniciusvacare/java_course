package interfaces.ex1;

public interface Veiculo {
    String tipo = "Veiculo";
    void iniciar();
    void parar();
    String getTipo();
    void setTipo(String tipo);

    default void buzinar() {
        System.out.println(Veiculo.tipo + " buzinando");
    }
}
