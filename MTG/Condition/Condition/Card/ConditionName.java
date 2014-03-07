package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionName extends Condition<Card> {
    private final String name;
    private final boolean mode;

    public ConditionName(boolean mode, String name) {
        this.name = name;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        return mode == (name.compareTo(target.name) == 0);
    }
}
