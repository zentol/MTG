package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionOwner extends Condition<Card> {
    private final int ownerID;

    public ConditionOwner(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.isOwner(ownerID);
    }
}
