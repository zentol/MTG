package Condition.TargetProperties;

import Card.Permanent;
import Condition.Condition;

public class ConditionTapped extends Condition<Permanent> {
    private final boolean tapped;

    public ConditionTapped(boolean tapped) {
        this.tapped = tapped;
    }

    @Override
    public boolean evaluate(Permanent o) {
        if (tapped) {
            return o.isTapped();
        } else {
            return !o.isTapped();
        }
    }

}
