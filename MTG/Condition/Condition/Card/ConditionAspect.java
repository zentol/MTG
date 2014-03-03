package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionAspect extends Condition<Card> {
    private final int[] aspectKeys;
    private final boolean mode;

    public ConditionAspect(int aspectKey, boolean mode) {
        this.aspectKeys = new int[]{aspectKey};
        this.mode = mode;
    }

    public ConditionAspect(int[] aspectKey, boolean mode) {
        this.aspectKeys = aspectKey;
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
