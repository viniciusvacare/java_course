package heranca;

public class App {
    public static void main(String[] args) {
        Mage m1 = new Mage();
        Mage m2 = new Mage(100, 500);

        m1.attack();
        m2.attack();
        System.out.println(m2.getMana());

        m1.castSpell("fire bolt", 20);
        m1.castSpell("fire bolt", 10);
    }
}
