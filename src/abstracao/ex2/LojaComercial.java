package abstracao.ex2;

public class LojaComercial extends Loja {

    public LojaComercial(String cnpj, String razaoSocial) {
        super(cnpj, razaoSocial);
    }

    @Override
    void abrir() {
        super.aberta = true;
    }

    @Override
    void fechar() {
        super.aberta = false;
    }

    @Override
    void lojaAberta() {
        System.out.println(super.razaoSocial + " está " + (super.aberta ? "aberta" : "fechada"));;
    }
}
