package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionType extends Condition<Card> {
    private final int type;
    private boolean mode;

    public ConditionType(boolean mode, int type) {
        this.type = type;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == (target.getType() == type);
    }
}
