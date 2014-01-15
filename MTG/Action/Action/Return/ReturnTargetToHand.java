package Action.Return;

import Action.Action;
import Card.Permanent;
import Card.Card;
import Condition.Condition;
import static Game.Game.battlefield;
import static Game.Game.graveyard;
import static Game.Game.hand;

public class ReturnTargetToHand extends Action{

    public static void returnTargetToHandFromBattlefield(Permanent permanent, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }
        if (allConditionsMet) {
            returnToHand(permanent);
        }
    }
    
    public static void returnTargetToHandFromGraveyard(Card Card, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(Card);
        }
        if (allConditionsMet) {
            returnToHand(Card);
        }
    }
    
    private static void returnToHand(Permanent permanent){
        battlefield.remove(permanent);
        hand.get(permanent.ownerID).add(permanent);
    }
    
    private static void returnToHand(Card Card){
        graveyard.get(Card.ownerID).remove(Card);
        hand.get(Card.ownerID).add(Card);
    }
}
