package orientacao_objetos;

public class Carro {
    private String marcaDoCarro, modeloDoCarro;
    private Integer anoDoCarro;

    public Carro(String marcaDoCarro, String modeloDoCarro, Integer anoDoCarro) {
        this.marcaDoCarro = marcaDoCarro;
        this.modeloDoCarro = modeloDoCarro;
        this.anoDoCarro = anoDoCarro;
    }

    public Carro(String marcaDoCarro, String modeloDoCarro) {
        this.marcaDoCarro = marcaDoCarro;
        this.modeloDoCarro = modeloDoCarro;
        this.anoDoCarro = 0;
    }

    public Carro() {
        this.marcaDoCarro = "Desconhecida";
        this.modeloDoCarro = "Desconhecido";
        this.anoDoCarro = 0;
    }

    public String exibirDetalhes() {
        return "O carro " + this.modeloDoCarro + " da marca " + this.marcaDoCarro + " é do ano " + this.anoDoCarro;
    }
}
