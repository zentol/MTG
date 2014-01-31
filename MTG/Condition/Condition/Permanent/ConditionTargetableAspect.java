
package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Protection.ModifierUntargetableAspect;

public class ConditionTargetableAspect extends Condition<Permanent> {
    private final int aspect;

    public ConditionTargetableAspect(int aspect) {
        this.aspect = aspect;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (target.modifiers.get(x).getClass().equals(ModifierUntargetableAspect.class)) {
                return !((ModifierUntargetableAspect) target.modifiers.get(x)).protectsAgainst(aspect);
            }
        }
        return true;
    }
}
