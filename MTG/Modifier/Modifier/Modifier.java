package Modifier;

import Card.Card;
import Effect.Effect;
import Game.InvalidTargetException;

public abstract class Modifier {
    public final Card target;
    public final Effect source;

    public Modifier(Card target, Effect source) {
        this.target = target;
        this.source = source;
    }

    public void evaluate() {
        try {
            source.activate(new Card[]{target});
        } catch (InvalidTargetException ite) {
            target.modifiers.remove(this);
        }
    }
}
