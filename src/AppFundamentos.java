import fundamentos.CalcularAreaRetangulo;
import fundamentos.ControleEstoquePadaria;
import fundamentos.InferenciaDeTipo;
import fundamentos.PromocaoAutomatica;

public class AppFundamentos {
    public static void main(String[] args) {
        PromocaoAutomatica promocaoAutomatica = new PromocaoAutomatica();

        float valor = promocaoAutomatica.getC();
        double outroValor = promocaoAutomatica.getF();

        System.out.println(valor);
        System.out.println(outroValor);

        InferenciaDeTipo inferenciaDeTipo = new InferenciaDeTipo();

        System.out.println(inferenciaDeTipo.retornaValorEmDobro(100));

        /////////////////////

        ControleEstoquePadaria estoque = new ControleEstoquePadaria(10, 5);

        estoque.exibeQuantidade();

        estoque.setQuantidadeFarinha(20);
        estoque.setQuantidadeAcucar(15);
        estoque.exibeQuantidade();

        estoque.adicionarAoEstoque("fárInha", 10);
        estoque.adicionarAoEstoque("açúCAR", 10);
        estoque.exibeQuantidade();

        estoque.adicionarAoEstoque(35);
        estoque.exibeQuantidade();

        //////////////////////

        CalcularAreaRetangulo areaRetangulo = new CalcularAreaRetangulo(5.0, 3.0);

        System.out.println("Area do retangulo: " + areaRetangulo.calcularAreaDeUmRetangulo());
    }
}
