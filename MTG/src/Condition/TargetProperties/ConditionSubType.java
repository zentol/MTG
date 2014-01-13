package Condition.Conditions;

import Card.Card;
import Condition.Condition;

public class ConditionSubType extends Condition<Card> {
    private final String[] subTypes;

    public ConditionSubType(String[] subTypes) {
        this.subTypes = subTypes;
    }

    @Override
    public boolean evaluate(Card card) {
        if (subTypes.length == 0) {
            return false;
        }
        for (String subType : subTypes) {
            card.hasType(subType);
            if (!card.hasType(subType)) {
                return false;
            }
        }
        return true;
    }

}
