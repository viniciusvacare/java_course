package generics.ex1;

public class Main {
    public static void main(String[] args) {
        Cesto<Peixe> peixeNoCesto = new Cesto<>();
        Cesto<Polvo> polvoNoCesto = new Cesto<>();

        peixeNoCesto.guardar(new Peixe("Tilapia", 1.30));
        polvoNoCesto.guardar(new Polvo("Polvo-alga", 2));

        System.out.println(peixeNoCesto.pegar().nome);
        System.out.println(polvoNoCesto.pegar().nome);
    }
}
