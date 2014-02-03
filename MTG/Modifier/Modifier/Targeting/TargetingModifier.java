
package Modifier.Targeting;

import Card.Card;
import Effect.Effect;
import Modifier.Modifier;

public abstract class TargetingModifier extends Modifier{

    public TargetingModifier(Effect source) {
        super(source);
    }
    public abstract boolean preventsTargeting(Card targeter);

}
