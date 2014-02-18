package Condition.Effect;

import Condition.Condition;
import Effect.Effect;

public class ConditionTargeting extends Condition<Effect> {
    public ConditionTargeting() {
    }

    @Override
    public boolean evaluate(Effect target) {
        return target.targetCount > 0;
    }

}
