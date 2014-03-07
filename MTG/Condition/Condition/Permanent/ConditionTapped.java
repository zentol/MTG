package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;

public class ConditionTapped extends Condition<Permanent> {
    private final boolean mode;

    public ConditionTapped(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent target) {
        return mode == target.isTapped();
    }

}
