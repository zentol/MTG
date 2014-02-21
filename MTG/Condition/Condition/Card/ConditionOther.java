package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionOther extends Condition<Card> {
    private final int instanceID;

    public ConditionOther(int instanceID) {
        this.instanceID = instanceID;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.equalsInstance(instanceID);
    }
}
