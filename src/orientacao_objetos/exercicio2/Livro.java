package orientacao_objetos.exercicio2;

public class Livro {
    public String titulo;
    private String autor;
    protected Integer anoPublicacao;
    Double preco;

    public Livro() {
        this.titulo = "Desconhecido";
        this.autor = "Desconhecido";
        this.anoPublicacao = 0;
        this.preco = 0.0;
    };

    public Livro(String consTitulo, String consAutor) {
        this.titulo = consTitulo;
        this.autor = consAutor;
        this.anoPublicacao = 0;
        this.preco = 0.0;
    };

    public Livro(String consTitulo, String consAutor, Integer consAnoPublicacao, Double consPreco) {
        this.titulo = consTitulo;
        this.autor = consAutor;
        this.anoPublicacao = consAnoPublicacao;
        this.preco = consPreco;
    };
}
