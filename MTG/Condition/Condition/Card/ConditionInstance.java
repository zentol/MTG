package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionInstance extends Condition<Card> {
    private final int[] instanceIDs;
    private final boolean mode;

    public ConditionInstance(boolean mode, int instanceID) {
        this(mode, new int[]{instanceID});
    }

    public ConditionInstance(boolean mode, int[] instanceIDs) {
        this.instanceIDs = instanceIDs;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        boolean instanceFound = false;
        for (int instanceID : instanceIDs) {
            instanceFound |= target.equalsInstance(instanceID);
        }
        return mode == instanceFound;
    }
}
