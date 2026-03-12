package orientacaoAObjetos.exercicio1;

public class SalaDeAula {
    private static int totalDeAlunos;

    public static int exibirTotalDeAlunos() {
        return totalDeAlunos;
    }

    public static void adicionarAluno(int totalDeAlunos) {
        SalaDeAula.totalDeAlunos += totalDeAlunos;
    }
}
