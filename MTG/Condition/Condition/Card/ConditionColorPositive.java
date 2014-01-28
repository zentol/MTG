package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionColorPositive extends Condition<Card> {
    private final String colors;

    public ConditionColorPositive(String colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Card target) {
        if (colors.isEmpty()) {
            return false;
        }
        for (int x = 0; x < colors.length(); x++) {
            if (!target.isColor(Character.toString(colors.charAt(x)))) {
                return false;
            }

        }
        return true;
    }

}
