package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionType extends Condition<Card> {
    private final int type;

    public ConditionType(int type) {
        this.type = type;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.getType() == type;
    }
}
