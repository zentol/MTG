package Effect;

import Card.Card;

public abstract class Effect<A extends Effect> {
    public Card source;

    public abstract void execute();

    public abstract void setTargets(Card[] targets);
}
