package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionController extends Condition<Card> {
    private final int[] controllerIDs;
    private final boolean mode;

    public ConditionController(boolean mode, int controllerID) {
        this(mode, new int[]{controllerID});
    }

    public ConditionController(boolean mode, int... controllerIDs) {
        this.controllerIDs = controllerIDs;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        boolean result = false;
        for (int id : controllerIDs) {
            result |= target.equalsController(id);
        }
        return mode == result;
    }
}
