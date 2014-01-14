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
        for (int y = 0; y < conditions.length; y++) {
            allConditionsMet &= conditions[y].evaluate(permanent);
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
        for (int x = 0; x < permanents.length; x++) {
            boolean allConditionsMet = true;
            for (int y = 0; y < conditions.length; y++) {
                allConditionsMet &= conditions[y].evaluate(permanents[x]);
            }
            if (allConditionsMet) {
                destroyPermanent(permanents[x]);
            }
        }
    }

    private static void destroyPermanent(Permanent p) {
        battlefield.remove(p);
        graveyard.get(p.ownerID).sendToGraveyard(p);
    }
}
