package Action;

import Card.Permanent;
import Card.Card;
import Condition.Condition;
import static Game.Game.battlefield;
import static Game.Game.graveyard;
import static Game.Game.hand;

public abstract class Return extends Action {
    /**
     Returns every permanent for whom ALL conditions are met to the respective owner's hand.
     @param conditions 
     */
    public static void returnAllToHandFromBattlefield(Condition[] conditions) {
        for (int x = 0; x < battlefield.size(); x++) {
            if (checkConditions(battlefield.get(x), conditions)) {
                returnToHandFromBattlefield(battlefield.get(x));
            }
        }
    }

    public static void returnTargetsToHandFromBattlefield(Permanent[] permanents, Condition[] conditions) {
        for (Permanent permanent : permanents) {
            if (checkConditions(permanent, conditions)) {
                returnToHandFromBattlefield(permanent);
            }
        }
    }

    private static void returnToHandFromBattlefield(Permanent permanent) {
        battlefield.remove(permanent);
        hand.get(permanent.ownerID).add(permanent);
    }

    public static void returnTargetsToHandFromGraveyard(Card[] cards, Condition[] conditions) {
        for (Card card : cards) {
            if (checkConditions(card, conditions)) {
                returnToHandFromGraveyard(card);
            }
        }
    }

    private static void returnToHandFromGraveyard(Card Card) {
        graveyard.get(Card.ownerID).remove(Card);
        hand.get(Card.ownerID).add(Card);
    }

    private static boolean checkConditions(Card card, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(card);
        }
        return allConditionsMet;
    }
}
