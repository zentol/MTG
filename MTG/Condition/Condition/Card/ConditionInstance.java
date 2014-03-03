package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionInstance extends Condition<Card> {
    private final int[] instanceIDs;

    public ConditionInstance(int instanceID) {
        this.instanceIDs = new int[]{instanceID};
    }

    public ConditionInstance(int[] instanceIDs) {
        this.instanceIDs = instanceIDs;
    }

    @Override
    public boolean evaluate(Card target) {
        boolean instanceFound = false;
        for (int instanceID : instanceIDs) {
            instanceFound |= target.equalsInstance(instanceID);
        }
        return instanceFound;
    }
}
