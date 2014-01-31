
package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Modifier;
import Modifier.Protection.ModifierUntargetableAspect;

public class ConditionTargetableAspect extends Condition<Permanent> {
    private final int aspect;

    public ConditionTargetableAspect(int aspect) {
        this.aspect = aspect;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (Modifier modifier:target.modifiers) {
            if (modifier.getClass().equals(ModifierUntargetableAspect.class)) {
                return !((ModifierUntargetableAspect) modifier).protectsAgainst(aspect);
            }
        }
        return true;
    }
}
