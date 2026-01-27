package heranca;

public class CharacterClass {

    private final Integer damage;

    public CharacterClass(Integer damage) {
        this.damage = damage;
    }

    public void attack() {
        System.out.println("attack mob");
    }
}
