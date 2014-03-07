package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionOther extends Condition<Card> {
    private final int instanceID;
    private final boolean mode;

    public ConditionOther(boolean mode, int instanceID) {
        this.instanceID = instanceID;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == target.equalsInstance(instanceID);
    }
}
