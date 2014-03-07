package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionAspect extends Condition<Card> {
    private final int[] aspectKeys;
    private final boolean mode;

    public ConditionAspect(boolean mode, int aspectKey) {
        this(mode, new int[]{aspectKey});
    }

    public ConditionAspect(boolean mode, int... aspectKeys) {
        this.aspectKeys = aspectKeys;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        boolean hasAspect = false;
        for (int aspectKey : aspectKeys) {
            hasAspect |= target.hasAspect(aspectKey);
        }
        return mode == hasAspect;
    }
}
