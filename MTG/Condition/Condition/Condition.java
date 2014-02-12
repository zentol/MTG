package Condition;

import Card.Card;

public abstract class Condition<E> {
    public static final int LESS = -1;
    public static final int EQUAL = 0;
    public static final int MORE = 1;

    public abstract boolean evaluate(E target);

    public static boolean checkConditions(Card target, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(target);
        }
        return allConditionsMet;
    }
}
