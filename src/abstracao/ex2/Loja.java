package abstracao.ex2;

public abstract class Loja {
    String cnpj;
    String razaoSocial;
    boolean aberta;

    public Loja(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    abstract void abrir();
    abstract void fechar();
    abstract void lojaAberta();
}
