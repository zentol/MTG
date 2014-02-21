package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionController extends Condition<Card> {
    private final int controllerID;

    public ConditionController(int controllerID) {
        this.controllerID = controllerID;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.equalsController(controllerID);
    }
}
