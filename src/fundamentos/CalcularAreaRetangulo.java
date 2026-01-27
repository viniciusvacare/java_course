package fundamentos;

public class CalcularAreaRetangulo {
    public CalcularAreaRetangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    double largura, altura;

    public double calcularAreaDeUmRetangulo() {
        return this.largura * this.altura;
    }
}
