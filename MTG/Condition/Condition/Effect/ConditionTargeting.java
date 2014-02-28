package Condition.Effect;

import Condition.Condition;
import Ability.Ability;

public class ConditionTargeting extends Condition<Ability> {
    public ConditionTargeting() {
    }

    @Override
    public boolean evaluate(Ability target) {
        return target.targetCount > 0;
    }

}
