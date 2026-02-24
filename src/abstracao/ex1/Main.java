package abstracao.ex1;

public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo(5.0, 3.0);
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro: " + retangulo.calcularPerimetro());
    }
}
