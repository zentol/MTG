package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionColorPositive extends Condition<Card> {
    private final int colors;

    public ConditionColorPositive(int colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Card target) {
        if (colors == 0) {
            return target.isColorless();
        }
        for (int x = 1; x < 6; x++) {
            if ((colors & x) == x && !target.isColor(x)) {
                return false;
            }
        }
        return true;
    }

}
