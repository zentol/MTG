package Card.Aspect.Permanent;

public class CreatureAspect extends PermanentAspect {
    private final int attack;
    private final int defense;
    private boolean summoningSickness;
    private int damageTaken;

    public boolean attacking;
    public boolean blocking;
    public boolean blocked;

    public CreatureAspect(int attack, int defense, String[] types) {
        super(types);
        this.summoningSickness = true;
        this.attack = attack;
        this.defense = defense;
        this.damageTaken = 0;
        this.attacking = false;
        this.blocking = false;
        this.blocked = false;
    }

    @Override
    public int getKey() {
        return KEY_ASPECT_CREATURE;
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

    public void clearDamage() {
        this.damageTaken = 0;
    }
}
