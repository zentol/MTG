package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionController extends Condition<Card> {
    private final int controllerID;
    private final boolean mode;

    public ConditionController(int controllerID, boolean mode) {
        this.controllerID = controllerID;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == target.equalsController(controllerID);
    }
}
