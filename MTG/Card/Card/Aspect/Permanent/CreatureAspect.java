package Card.Aspect.Permanent;

public class CreatureAspect extends PermanentAspect {
    private final int attack;
    private final int defense;
    private boolean summoningSickness;
    private int damageTaken;

    public CreatureAspect(int attack, int defense, String[] types) {
        super(types);
        this.summoningSickness = true;
        this.attack = attack;
        this.defense = defense;
        this.damageTaken = 0;
    }

    public void disableSummoningSickness() {
        summoningSickness = false;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void dealDamage(int damage) {
        this.damageTaken += damage;
    }
}
