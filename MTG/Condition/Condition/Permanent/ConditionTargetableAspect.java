
package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Effect.Type.Static.StaticUntargetableAspect;

public class ConditionTargetableAspect extends Condition<Permanent> {
    private final int aspect;

    public ConditionTargetableAspect(int aspect) {
        this.aspect = aspect;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (target.modifiers.get(x).getClass().equals(StaticUntargetableAspect.class)) {
                return !((StaticUntargetableAspect) target.modifiers.get(x)).protectsAgainst(aspect);
            }
        }
        return true;
    }
}
