package annotations;

import jdk.jfr.Name;

public class Exemplo extends ExemploHeranca {
    private int salario;

    public Exemplo(String nome, int salario) {
        super(nome);
        this.salario = salario;
    }

    public void setSalario(int valor) {
        this.salario = valor;
    }
    
    @Override
    public void retornaMensagem() {
        super.retornaMensagem();
        System.out.println("eai meu mano " + super.getNome());
    }
}
