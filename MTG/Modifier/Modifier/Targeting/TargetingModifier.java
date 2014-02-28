package Modifier.Targeting;

import Card.Card;
import Ability.Ability;
import Modifier.Modifier;

public abstract class TargetingModifier extends Modifier {

    public TargetingModifier(Card target, Ability source) {
        super(target, source);
    }

    public abstract boolean preventsTargeting(Card targeter);

}
