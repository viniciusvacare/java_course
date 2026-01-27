package orientacao_objetos;

public class Funcionario {

    private String nome;
    private Double salario;

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario() {
    }

    public Double getSalario() {
        return salario == null ? 0 : salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
