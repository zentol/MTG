package Modifier.Protection;

import Card.Card;
import Modifier.Modifier;

public class ModifierInvulnerableAspect extends Modifier {
    private final int aspect;

    public ModifierInvulnerableAspect(Card source, int aspect) {
        super(source);
        this.aspect = aspect;
    }

    public boolean protectsAgainst(int aspect) {
        return this.aspect == aspect;
    }
}
