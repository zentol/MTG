package Condition.Effect;

import Condition.Condition;
import Ability.Ability;

public class ConditionTargeting extends Condition<Ability> {
    private final boolean mode;

    public ConditionTargeting(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Ability target) {
        return mode == (target.targetCount > 0);
    }

}
