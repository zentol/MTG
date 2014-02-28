package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionColor extends Condition<Card> {
    private final int colors;
    private final boolean mode;

    public ConditionColor(int colors, boolean mode) {
        this.colors = colors;
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Card target) {
        if (colors == 0) {
            return mode==target.isColorless();
        }
        for (int x = 1; x < 6; x++) {
            if ((colors & x) == x && !target.isColor(x)) {
                return mode==false;
            }
        }
        return mode==true;
    }

}
