package Action.Destroy;

import Action.Action;
import Card.Permanent;
import Condition.Condition;
import Condition.Permanent.ConditionDestructible;
import static Game.Game.*;
import static Game.Game.graveyard;

public class DestroyAll extends Action {
    private static ConditionDestructible destructible = new ConditionDestructible();
    
    /**
    Destroys every permanent for whom ALL conditions are met.
    @param conditions conditions to meet
    */
    public static void destroyAll(Condition[] conditions) {
        for (int x = 0; x < battlefield.size(); x++) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(battlefield.get(x));
            }
            allConditionsMet &= destructible.evaluate(battlefield.get(x));
            if (allConditionsMet) {
                destroyPermanent(battlefield.get(x));
            }
        }
    }

    private static void destroyPermanent(Permanent p) {
        battlefield.remove(p);
        graveyard.get(p.ownerID).sendToGraveyard(p);
    }
}
