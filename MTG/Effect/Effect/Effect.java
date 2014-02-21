package Effect;

import Card.Card;

public abstract class Effect {
    public Card source;
    public final int targetCount;
    public final int type;

    public static final int KEY_EFFECT_TYPE_STATIC = 1;
    public static final int KEY_EFFECT_TYPE_ACTIVATED = 2;
    public static final int KEY_EFFECT_TYPE_TRIGGERED = 3;
    public static final int KEY_EFFECT_TYPE_SPELL = 4;

    public Effect(int targetCount, int type) {
        this.targetCount = targetCount;
        this.type = type;
    }

    public abstract void activate(Card[] targets);

    public abstract void execute();

    public int getType() {
        return type;
    }

    public void setSource(Card source) {
        this.source = source;
    }

}
