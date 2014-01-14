package Condition.Card;

import Card.Card;
import Card.Aspect.Aspect;
import Condition.Condition;

public class ConditionAspect extends Condition<Card> {
    private final Class aspect;

    public ConditionAspect(Class<? extends Aspect> aspect) {
        this.aspect = aspect;
    }

    @Override
    public boolean evaluate(Card target) {
        return target.hasAspect(aspect);
    }
}
