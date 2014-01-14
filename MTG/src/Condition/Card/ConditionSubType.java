package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionSubType extends Condition<Card> {
    private final String[] subTypes;

    public ConditionSubType(String[] subTypes) {
        this.subTypes = subTypes;
    }

    @Override
    public boolean evaluate(Card target) {
        if (subTypes.length == 0) {
            return false;
        }
        for (String subType : subTypes) {
            target.hasType(subType);
            if (!target.hasType(subType)) {
                return false;
            }
        }
        return true;
    }
}
