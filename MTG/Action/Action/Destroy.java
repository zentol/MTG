package Action;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Condition.Permanent.ConditionDestructible;
import static Game.Game.battlefield;
import static Game.Game.graveyard;

public abstract class Destroy {
    private static final ConditionDestructible destructible = new ConditionDestructible(true);

    /**
     Destroys every permanent for whom ALL conditions are met.
     @param conditions conditions to meet
     @param source action source
     */
    public static void destroyAll(Condition[] conditions, Card source) {
        for (int x = 0; x < battlefield.size(); x++) {
            if (checkConditions(battlefield.get(x), conditions) & destroyConditions(battlefield.get(x), source)) {
                destroyPermanent(battlefield.get(x));
            }
        }
    }

    public static void destroyTarget(Permanent permanent, Condition[] conditions, Card source) {
        if (checkConditions(permanent, conditions) & destroyConditions(permanent, source)) {
            destroyPermanent(permanent);
        }
    }

    /**
     Destroys every target permanents for whom ALL conditions are met.
     * @param permanents
     @param conditions conditions to meet
     * @param source action source
     */
    public static void destroyTargets(Permanent[] permanents, Condition[] conditions, Card source) {
        for (Permanent permanent : permanents) {
            destroyTarget(permanent, conditions, source);
        }
    }

    private static boolean destroyConditions(Permanent target, Card source) {
        boolean destroyConditionsMet = true;
        destroyConditionsMet &= destructible.evaluate(target);
        return destroyConditionsMet;
    }

    private static void destroyPermanent(Permanent target) {
        battlefield.remove(target);
        target.resetModifiers();
        graveyard.get(target.ownerID).sendToGraveyard(target);
    }
}
