package Card.Aspect.Permanent;

import Effect.Effect;

public class CreatureAspect extends PermanentAspect {
    private final int attack;
    private final int defense;
    private boolean summoningSickness;
    private final Effect[] effects;

    public CreatureAspect(int attack, int defense, String[] types, Effect[] effects) {
        super(types);
        
        this.summoningSickness = true;
        this.attack = attack;
        this.defense = defense;
        this.effects = effects;
    }

    public void disableSumminingSickness() {
        summoningSickness = false;
    }
}
