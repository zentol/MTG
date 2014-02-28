package Modifier;

import Card.Card;
import Ability.Ability;
import Game.InvalidTargetException;

public abstract class Modifier {
    public final Card target;
    public final Ability source;

    public Modifier(Card target, Ability source) {
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
