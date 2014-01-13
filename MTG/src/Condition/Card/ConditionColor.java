package Condition.Card;

import Card.Card;
import Condition.Condition;

public class ConditionColor extends Condition<Card> {
    private final String colors;

    public ConditionColor(String colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Card card) {
        if (colors.isEmpty()) {
            return false;
        }
        for (int x = 0; x < colors.length(); x++) {
            if (!card.hasColor(Character.toString(colors.charAt(x)))) {
                return false;
            }

        }
        return true;
    }

}
