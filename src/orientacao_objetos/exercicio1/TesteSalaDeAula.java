package orientacao_objetos.exercicio1;

public class TesteSalaDeAula {
    public static void main(String[] args) {
        SalaDeAula.adicionarAluno(10);
        SalaDeAula.adicionarAluno(30);
        SalaDeAula.adicionarAluno(10);

        System.out.println(SalaDeAula.exibirTotalDeAlunos());
    }
}
