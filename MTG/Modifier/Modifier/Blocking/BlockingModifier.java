package Modifier.Blocking;

import Card.Card;
import Effect.Effect;
import Modifier.Modifier;

public abstract class BlockingModifier extends Modifier {

    public BlockingModifier(Card target, Effect source) {
        super(target, source);
    }

}
