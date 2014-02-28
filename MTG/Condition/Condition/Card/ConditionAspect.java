package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionAspect extends Condition<Card> {
    private final int aspectKey;
    private final boolean mode;

    public ConditionAspect(int aspectKey, boolean mode) {
        this.aspectKey = aspectKey;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode==target.hasAspect(aspectKey);
    }
}
