package Effect;

import Card.Card;

public abstract class Effect {
    public Card source;
    public final boolean targeting;

    public static final int KEY_EFFECT_TYPE_STATIC = 1;
    public static final int KEY_EFFECT_TYPE_ACTIVATED = 2;
    public static final int KEY_EFFECT_TYPE_TRIGGERED = 3;
    public static final int KEY_EFFECT_TYPE_SPELL = 4;

    public Effect(boolean targeting) {
        this.targeting = targeting;
    }

    public abstract void activate(Card[] targets);

    public abstract void execute();

    public abstract int getType();
    
}
