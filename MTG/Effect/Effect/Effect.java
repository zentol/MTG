package Effect;

import Card.Card;

public abstract class Effect {
    public Card source;
    public final boolean targeting;

    public Effect(boolean targeting) {
        this.targeting = targeting;
    }

    public abstract void activate(Card[] targets);

    public abstract void execute();
}
