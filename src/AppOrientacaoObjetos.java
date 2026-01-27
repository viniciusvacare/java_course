import orientacao_objetos.Carro;
import orientacao_objetos.Funcionario;
import orientacao_objetos.Produto;

public class AppOrientacaoObjetos {
    private static String retornaAlgo() {
        return "mensagem de teste";
    }

    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        Funcionario f2 = new Funcionario();
        Funcionario f3 = new Funcionario("Ciclano", 23444.90);
        Funcionario f4 = new Funcionario("Sem Ideia da Silva");

        f1.setNome("Fulano");
        f2.setNome("Beltrano");

        f1.setSalario(2314.90);
        f2.setSalario(5440.00);

        System.out.println(f1.getNome() + " tem o salario de " + f1.getSalario());
        System.out.println(f2.getNome() + " tem o salario de " + f2.getSalario());
        System.out.println(f3.getNome() + " tem o salario de " + f3.getSalario());
        System.out.println(f4.getNome() + " tem o salario de " + f4.getSalario());

        System.out.println(AppOrientacaoObjetos.retornaAlgo());

        // Atividade
        Produto p1 = new Produto("Caneta", 3.99, 19);

        System.out.println(p1.getNome());

        p1.alterarNome(p1, "Caneta Preta");
        System.out.println(p1.getNome());

        System.out.println(p1.getPreco());
        System.out.println(p1.getQuantidadeEmEstoque());

        p1.setQuantidadeEmEstoque(p1.getQuantidadeEmEstoque() - 1);
        System.out.println(p1.getQuantidadeEmEstoque());

        Carro carroNenhum = new Carro();
        Carro carroMarcaEModelo = new Carro("Wolkswagen", "Gol");
        Carro carroTodos = new Carro("Chevrolet", "Corsa", 2001);

        System.out.println(carroNenhum.exibirDetalhes());
        System.out.println(carroMarcaEModelo.exibirDetalhes());
        System.out.println(carroTodos.exibirDetalhes());
    }
}
