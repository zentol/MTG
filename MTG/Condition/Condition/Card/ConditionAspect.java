package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionAspect extends Condition<Card> {
    private final int aspectKey;

    public ConditionAspect(int aspectKey) {
        this.aspectKey = aspectKey;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.hasAspect(aspectKey);
    }
}
