package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionMulticolored extends Condition<Card> {

    public ConditionMulticolored() {
    }

    @Override
    public boolean evaluate(Card target) {
        return target.isMulticolored();
    }

}
