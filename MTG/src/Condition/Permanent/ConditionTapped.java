package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;

public class ConditionTapped extends Condition<Permanent> {
    private final boolean tapped;

    public ConditionTapped(boolean tapped) {
        this.tapped = tapped;
    }

    @Override
    public boolean evaluate(Permanent target) {
        if (tapped) {
            return target.isTapped();
        } else {
            return !target.isTapped();
        }
    }

}
