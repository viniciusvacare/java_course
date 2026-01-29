package heranca;

public class CharacterClass {

    private final int damage;

    public CharacterClass(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage não pode ser negativo");
        }
        this.damage = damage;
    }

    public void attack() {
        System.out.println("Atacando mob com " + damage + " de dano");
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "CharacterClass{damage=" + damage + "}";
    }
}
