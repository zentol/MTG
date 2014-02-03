package Modifier.Damaging;

import Effect.Effect;
import Modifier.Modifier;

public class ModifierInvulnerableAspect extends Modifier {
    private final int aspect;

    public ModifierInvulnerableAspect(Effect source, int aspect) {
        super(source);
        this.aspect = aspect;
    }

    public boolean protectsAgainst(int aspect) {
        return this.aspect == aspect;
    }
}
