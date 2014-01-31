package Modifier.Protection;

import Card.Card;
import Modifier.Modifier;

public class ModifierUntargetableAspect extends Modifier {
    private final int aspect;

    public ModifierUntargetableAspect(Card source, int aspect) {
        super(source);
        this.aspect = aspect;
    }

    public boolean protectsAgainst(int aspect) {
        return this.aspect == aspect;
    }
}
