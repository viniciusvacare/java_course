package abstracao.ex2;

public class Main {
    public static void main(String[] args) {
        LojaComercial lojaComercial = new LojaComercial("1234567890", "Loja Comercial do Teste");
        lojaComercial.abrir();
        lojaComercial.lojaAberta();
        lojaComercial.fechar();
        lojaComercial.lojaAberta();
    }
}
