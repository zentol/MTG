package Modifier.Damaging;

import Card.Card;
import Ability.Ability;
import Modifier.Modifier;

public class ModifierInvulnerableAspect extends Modifier {
    private final int aspect;

    public ModifierInvulnerableAspect(Card target, Ability source, int aspect) {
        super(target, source);
        this.aspect = aspect;
    }

    public boolean protectsAgainst(int aspect) {
        return this.aspect == aspect;
    }
}
