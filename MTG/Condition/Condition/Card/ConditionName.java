package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionName extends Condition<Card> {
    private final String name;

    public ConditionName(String name) {
        this.name = name;
    }

    @Override
    public boolean evaluate(Card target) {
        return name.compareTo(target.name) == 0;
    }
}
