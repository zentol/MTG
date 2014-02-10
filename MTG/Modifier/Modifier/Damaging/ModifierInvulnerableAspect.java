package Modifier.Damaging;

import Card.Card;
import Effect.Effect;
import Modifier.Modifier;

public class ModifierInvulnerableAspect extends Modifier {
    private final int aspect;

    public ModifierInvulnerableAspect(Card target, Effect source, int aspect) {
        super(target, source);
        this.aspect = aspect;
    }

    public boolean protectsAgainst(int aspect) {
        return this.aspect == aspect;
    }
}
