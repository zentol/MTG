package Modifier.Targeting;

import Card.Card;
import Ability.Ability;

public class ModifierUntargetableAspect extends TargetingModifier {
    private final int aspect;

    public ModifierUntargetableAspect(Card target, Ability source, int aspect) {
        super(target, source);
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
