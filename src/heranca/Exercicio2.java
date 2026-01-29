package heranca;

public class Exercicio2 {
    public static void main(String[] args) {
        Assistente as1 = new Assistente(1500.00);

        as1.addAumento(10);
        as1.addAumento(10);
        as1.addAumento(10);
        as1.addAumento(10);

        System.out.println(as1.getSalario());
        System.out.println(as1.ganhoAnual());
    }
}

class Funcionario {
    private double salario;

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public void addAumento(double porcentagem) {
        double novoSalario = this.salario * porcentagem / 100;
        System.out.println("Seu salario foi de " + this.salario + " para " + (this.salario + novoSalario));
        this.salario += novoSalario;
    }

    public double ganhoAnual() {
        return Math.round(this.salario * 12);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

class Assistente extends Funcionario {
    public Assistente(double salario) {
        super(salario);
    }

    @Override
    public double ganhoAnual() {
        return (super.getSalario() * 12) + 1000;
    }
}

