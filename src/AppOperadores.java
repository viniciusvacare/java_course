import operadores.Atribuicao;
import operadores.Comparacao;
import operadores.Logicos;
import operadores.Unarios;
import operadores.exercicios.CalculadoraSimples;
import operadores.exercicios.OperadoresAtribuicaoExercicio;

public class AppOperadores {
    public static void main(String[] args) {
        Comparacao comparar = new Comparacao();
        Logicos logicos = new Logicos(600, 120);
        Atribuicao atribuir = new Atribuicao();

        comparar.setNumero1(20);
        comparar.setNumero2(20);

        comparar.getSinalDeComparacao();

        int tipo = 1;
        String resultado = comparar.comparaValoresPorSinal(tipo);

        System.out.println(resultado);
        System.out.println(logicos.resultado());

        atribuir.setValor(100);
        atribuir.adicionarValor(100);
        atribuir.adicionarValor(50.569);
        atribuir.multiplicarValor(2);
        atribuir.resetarValorInicial();
        atribuir.restoValor(30);
        atribuir.dividirValor(2);
        atribuir.mostrarValorAtual();

        Unarios unario = new Unarios();

        unario.retornaValor();
        unario.posIncremento();
        unario.retornaValor();

        System.out.println();
        System.out.println("Exercicios");
        System.out.println();
        System.out.println("CalculadoraSimples");
        CalculadoraSimples calculadoraSimples = new CalculadoraSimples();
        calculadoraSimples.a = 10;
        calculadoraSimples.b = 20;
        calculadoraSimples.retornaValores();
        System.out.println("--------------------------------------");
        System.out.println("OperadoresAtribuicaoExercicio");
        int value = OperadoresAtribuicaoExercicio.valorFinal(5);
        System.out.println(value);
        System.out.println("--------------------------------------");
    }
}