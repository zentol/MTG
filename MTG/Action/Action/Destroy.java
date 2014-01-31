package Action;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Condition.Permanent.ConditionDestructible;
import static Game.Game.*;

public abstract class Destroy extends Action {
    private static final ConditionDestructible destructible = new ConditionDestructible();

    /**
     Destroys every permanent for whom ALL conditions are met.
     @param conditions conditions to meet
     @param source action source
     */
    public static void destroyAll(Condition[] conditions, Card source) {
        for (int x = 0; x < battlefield.size(); x++) {
            if (destroyAllConditions(battlefield.get(x), conditions, source) & destroyConditions(battlefield.get(x), source)) {
                destroyPermanent(battlefield.get(x));
            }
        }
    }

    public static boolean destroyAllConditions(Permanent target, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(target);
        }
        return allConditionsMet;
    }

    public static void destroyTarget(Permanent permanent, Condition[] conditions, Card source) {
        if (destroyTargetConditions(permanent, conditions, source) & destroyConditions(permanent, source)) {
            destroyPermanent(permanent);
        }
    }

    public static boolean destroyTargetConditions(Permanent permanent, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }
        return allConditionsMet;
    }

    /**
     Destroys every target permanents for whom ALL conditions are met.
     * @param permanents
     @param conditions conditions to meet
     */
    public static void destroyTargets(Permanent[] permanents, Condition[] conditions, Card source) {
        for (Permanent permanent : permanents) {
            if (destroyTargetConditions(permanent, conditions, source)) {
                destroyPermanent(permanent);
            }
        }
    }

    public static int destroyTargetsConditions(Permanent[] permanents, Condition[] conditions, Card source) {
        int validTargets = 0;
        for (Permanent permanent : permanents) {
            if (destroyTargetConditions(permanent, conditions, source)) {
                validTargets++;
            }
        }
        return validTargets;
    }

    private static boolean destroyConditions(Permanent target, Card source) {
        boolean destroyConditionsMet = true;
        destroyConditionsMet &= destructible.evaluate(target);
        //destructible by type
        //destructible by subtype
        return destroyConditionsMet;
    }

    private static void destroyPermanent(Permanent target) {
        battlefield.remove(target);
        target.resetModifiers();
        graveyard.get(target.ownerID).sendToGraveyard(target);
    }
}
