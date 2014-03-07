package Condition.Card;

import Card.Permanent;
import Condition.Condition;

public class ConditionLegendary extends Condition<Permanent> {
    private final boolean mode;

    public ConditionLegendary(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent target) {
        return mode == target.legendary;
    }

}
