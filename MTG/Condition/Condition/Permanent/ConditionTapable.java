package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;

public class ConditionTapable extends Condition<Permanent> {

    @Override
    public boolean evaluate(Permanent target) {
        return !target.isTapped();
    }
}
