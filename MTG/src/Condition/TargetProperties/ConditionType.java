package Condition.TargetProperties;

import Card.Card;
import Condition.Condition;

public class ConditionType extends Condition<Card> {
    private final Class type;

    public ConditionType(Class<? extends Card> type) {
        this.type = type;
    }

    @Override
    public boolean evaluate(Card card) {
        return card.getClass().equals(type);
    }
}