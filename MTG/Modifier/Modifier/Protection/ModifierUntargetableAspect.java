package Modifier.Protection;

import Card.Card;

public class ModifierUntargetableAspect extends TargetingModifier {
    private final int aspect;

    public ModifierUntargetableAspect(Card source, int aspect) {
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
