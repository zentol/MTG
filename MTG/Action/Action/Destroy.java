package Action;

import Action.Action;
import Card.Permanent;
import Condition.Condition;
import Condition.Permanent.ConditionDestructible;
import static Game.Game.*;

public abstract class Destroy extends Action {
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
     * @param permanents
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
