package Action.Return;

import Action.Action;
import Card.Permanent;
import Card.Proxy;
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
    
    public static void returnTargetToHandFromGraveyard(Proxy proxy, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(proxy);
        }
        if (allConditionsMet) {
            returnToHand(proxy);
        }
    }
    
    private static void returnToHand(Permanent permanent){
        battlefield.remove(permanent);
        hand.get(permanent.ownerID).add(permanent);
    }
    
    private static void returnToHand(Proxy proxy){
        graveyard.get(proxy.ownerID).remove(proxy);
        hand.get(proxy.ownerID).add(proxy);
    }
}
