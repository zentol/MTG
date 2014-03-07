package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionMulticolored extends Condition<Card> {
    private final boolean mode;

    public ConditionMulticolored(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == target.isMulticolored();
    }

}
