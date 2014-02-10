/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Condition;

import Card.Card;

/**
 *
 * @author Zento
 */
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
