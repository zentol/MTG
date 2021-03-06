package Condition.Permanent;

import Card.Card;
import Condition.Condition;
import Modifier.Targeting.TargetingModifier;

public class ConditionTargetable extends Condition<Card> {
    private Card source;
    private final boolean mode;

    public ConditionTargetable(boolean mode, Card source) {
        this.source = source;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        boolean targetConditionsMet = true;
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (TargetingModifier.class.isInstance(target.modifiers.get(x))) {
                targetConditionsMet &= !((TargetingModifier) target.modifiers.get(x)).preventsTargeting(source);
            }
        }
        return mode == targetConditionsMet;
    }
}
