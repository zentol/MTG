package Modifier.Targeting;

import Card.Aspect.Aspect;
import Card.Card;
import Effect.Effect;

public class ModifierUntargetableSubType extends TargetingModifier {
    private final String[] subTypes;

    public ModifierUntargetableSubType(Effect source, String[] subTypes) {
        super(source);
        this.subTypes = subTypes;
    }

    @Override
    public boolean preventsTargeting(Card targeter) {
        boolean preventsTargeting = false;
        for (Aspect aspect : targeter.aspects) {
            for (int y = 0; y < aspect.subType.size(); y++) {
                for (String targetSubType : aspect.subType) {
                    for (String subType : subTypes) {
                        preventsTargeting |= (targetSubType.compareTo(subType) == 0);
                    }
                }
            }
        }
        return preventsTargeting;
    }
}
