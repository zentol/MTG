package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionOwner extends Condition<Card> {
    private final int ownerID;
    private final boolean mode;

    public ConditionOwner(boolean mode, int ownerID) {
        this.ownerID = ownerID;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == target.equalsOwner(ownerID);
    }
}
