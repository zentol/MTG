package Condition.Card;

import Card.Permanent;
import Condition.Condition;

public class ConditionLegendary extends Condition<Permanent> {

    public ConditionLegendary() {
    }

    @Override
    public boolean evaluate(Permanent target) {
        return target.legendary;
    }

}
