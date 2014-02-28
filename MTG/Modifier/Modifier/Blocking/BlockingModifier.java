package Modifier.Blocking;

import Card.Card;
import Ability.Ability;
import Modifier.Modifier;

public abstract class BlockingModifier extends Modifier {

    public BlockingModifier(Card target, Ability source) {
        super(target, source);
    }

}
