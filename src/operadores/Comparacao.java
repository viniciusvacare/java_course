package operadores;

public class Comparacao {
    int numero1, numero2;

    public boolean comparaSeValoresSaoIguais() {
        return this.numero1 == this.numero2;
    }

    public boolean comparaSeValoresSaoDiferentes() {
        return this.numero1 != this.numero2;
    }

    public boolean comparaSeOPrimeiroValorEhMaiorQueOSegundo() {
        return this.numero1 > this.numero2;
    }

    public boolean comparaSeOPrimeiroValorEhMenorQueOSegundo() {
        return this.numero1 < this.numero2;
    }

    public boolean comparaSeOPrimeiroValorEhMaiorOuIgualAoSegundo() {
        return this.numero1 >= this.numero2;
    }

    public boolean comparaSeOPrimeiroValorEhMenorOuIgualAoSegundo() {
        return this.numero1 <= this.numero2;
    }

    public String comparaValoresPorSinal(int tipo) {
        return switch (tipo) {
            case 1 -> this.comparaSeValoresSaoIguais() ? "SÃO IGUAIS" : "SÃO DIFERENTES";
            case 2 -> this.comparaSeValoresSaoDiferentes() ? "SÃO DIFERENTES" : "SÃO IGUAIS";
            case 3 -> this.comparaSeOPrimeiroValorEhMaiorQueOSegundo() ? "MAIOR QUE O SEGUNDO" : "MENOR QUE O SEGUNDO";
            case 4 -> this.comparaSeOPrimeiroValorEhMenorQueOSegundo() ? "MENOR QUE O SEGUNDO" : "MAIOR QUE O SEGUNDO";
            case 5 -> this.comparaSeOPrimeiroValorEhMaiorOuIgualAoSegundo() ? "MAIOR OU IGUAL AO SEGUNDO" : "MENOR QUE O SEGUNDO";
            case 6 -> this.comparaSeOPrimeiroValorEhMenorOuIgualAoSegundo() ? "MENOR OU IGUAL AO SEGUNDO" : "MAIOR QUE O SEGUNDO";
            default -> "O tipo informado não é válido.";
        };
    }

    public void getSinalDeComparacao() {
        System.out.println("--------------------------------------");
        System.out.println("1 == -> Igual a");
        System.out.println("2 != -> Diferente de");
        System.out.println("3 >  -> Maior que");
        System.out.println("4 <  -> Menor que");
        System.out.println("5 >= -> Maior ou igual a");
        System.out.println("6 <= -> Menor ou igual a");
        System.out.println("--------------------------------------");
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero1() {
        return this.numero1;
    }

    public int getNumero2() {
        return this.numero2;
    }
}
