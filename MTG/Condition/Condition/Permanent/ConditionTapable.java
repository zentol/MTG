package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;

public class ConditionTapable extends Condition<Permanent> {
    private final boolean mode;

    public ConditionTapable(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent target) {
        return mode == !target.isTapped();
    }
}
