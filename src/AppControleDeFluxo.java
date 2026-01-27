import fluxo.IfElse;
import fluxo.Switch;

public class AppControleDeFluxo {
	public static void main(String[] args) {
		IfElse admin = new IfElse();
		
		admin.setPermiteAcesso(!false);

		if (admin.isPermiteAcesso()) {
			System.out.println("Acesso permitido!");
		} else {
			System.out.println("Acesso negado!!!");
		}
		
		int numero = 11;
		String validaNumero = numero % 2 == 0 ? "Par" : "Impar";
		
		System.out.println(validaNumero);
		
		Object valor = 12039.23;
		boolean testaValor = valor instanceof String;
		
		System.out.println(testaValor ? "É do tipo String" : "Não é String");

		Switch diaDaSemana = new Switch();

		System.out.println(diaDaSemana.retornaDiaPorEscritoComSwitchExpression(2));
		System.out.println(diaDaSemana.retornaDiaPorEscritoComSwitchInitialization(3));
		System.out.println(diaDaSemana.validaSeEhDiaUtil(8));
	}
}