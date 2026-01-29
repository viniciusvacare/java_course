package heranca;

public class Mage extends CharacterClass {

    private int mana;
    private static final int DEFAULT_DAMAGE = 15;
    private static final int DEFAULT_MANA = 100;

    public Mage(int damage, int mana) {
        super(damage);
        if (mana < 0) {
            throw new IllegalArgumentException("Mana não pode ser negativo");
        }
        this.mana = mana;
    }

    public Mage() {
        this(DEFAULT_DAMAGE, DEFAULT_MANA);
    }

    @Override
    public void attack() {
        System.out.println("Mago lança feitiço causando " + getDamage() + " de dano mágico!");
    }

    public void castSpell(String spellName, int spellValue) {
        if (mana >= spellValue) {
            setMana(getMana() - spellValue);
            System.out.println("Mago lança " + spellName + " gastando " + spellValue + " de mana!");
        } else {
            System.out.println("Mana insuficiente para lançar " + spellName);
        }
    }

    public int getMana() {
        return mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Mage{damage=" + getDamage() + ", mana=" + mana + "}";
    }
}