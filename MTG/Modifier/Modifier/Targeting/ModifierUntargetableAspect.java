package Modifier.Targeting;

import Card.Card;
import Effect.Effect;

public class ModifierUntargetableAspect extends TargetingModifier {
    private final int aspect;

    public ModifierUntargetableAspect(Effect source, int aspect) {
        super(source);
        this.aspect = aspect;
    }

    @Override
    public boolean preventsTargeting(Card targeter) {
        int[] targeterAspects = targeter.getAspects();
        boolean prevents = false;
        for (int aspect : targeterAspects) {
            prevents |= (this.aspect == aspect);
        }
        return prevents;
    }
}
