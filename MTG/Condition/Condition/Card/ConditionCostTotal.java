package Condition.Card;

import Card.Card;
import Condition.Condition;
import static java.lang.Integer.parseInt;

public class ConditionCostTotal extends Condition<Card> {
    private final int costTotal;
    private final int mode;

    public ConditionCostTotal(int costTotal, int mode) {
        this.costTotal = costTotal;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        switch (mode) {
            case LESS:
                return costTotal < calcCost(target);
            case EQUAL:
                return costTotal == calcCost(target);
            case MORE:
                return costTotal > calcCost(target);
        }
        return false;
    }

    private int calcCost(Card target) {
        int cost = 0;
        int colorlesOffset = 0;
        try {
            cost += parseInt(Character.toString(target.cost.charAt(0)));
            colorlesOffset = 1;
        } catch (NumberFormatException nfe) {
        }
        cost += target.cost.length() - colorlesOffset;
        return cost;
    }
}
