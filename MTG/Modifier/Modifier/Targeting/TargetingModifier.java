
package Modifier.Targeting;

import Card.Card;
import Modifier.Modifier;

public abstract class TargetingModifier extends Modifier{

    public TargetingModifier(Card source) {
        super(source);
    }
    public abstract boolean preventsTargeting(Card targeter);

}
