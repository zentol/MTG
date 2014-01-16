package Action.Destroy;

import Card.Permanent;
import Condition.Condition;
import static Game.Game.battlefield;
import static Game.Game.graveyard;

public class DestroyTarget {

    /**
     Destroys target permanents for whom ALL conditions are met.
     @param conditions conditions to meet
     */
    public static void destroyTarget(Permanent permanent, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }
        if (allConditionsMet) {
            destroyPermanent(permanent);
        }
    }

    /**
     Destroys every target permanents for whom ALL conditions are met.
     @param conditions conditions to meet
     */
    public static void destroyTargets(Permanent[] permanents, Condition[] conditions) {
        for (Permanent permanent : permanents) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(permanent);
            }
            if (allConditionsMet) {
                destroyPermanent(permanent);
            }
        }
    }

    private static void destroyPermanent(Permanent target) {
        battlefield.remove(target);
        graveyard.get(target.ownerID).sendToGraveyard(target);
    }
}
