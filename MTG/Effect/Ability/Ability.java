package Ability;

import Card.Card;

public abstract class Ability {
    public Card source;
    public final int targetCount;
    public final int type;

    public static final int KEY_ABILITY_TYPE_STATIC = 1;
    public static final int KEY_ABILITY_TYPE_ACTIVATED = 2;
    public static final int KEY_ABILITY_TYPE_TRIGGERED = 3;
    public static final int KEY_ABILITY_TYPE_SPELL = 4;

    public Ability(int targetCount, int type) {
        this.targetCount = targetCount;
        this.type = type;
    }

    public abstract void activate(Card[] targets);

    public abstract void execute();

    public abstract void payCost();

    public int getType() {
        return type;
    }

    public void setSource(Card source) {
        this.source = source;
    }
}
