package Action;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Condition.Permanent.ConditionDestructible;
import Condition.Permanent.ConditionVulnerableColor;
import static Game.Game.*;

public abstract class Destroy extends Action {
    private static ConditionDestructible destructible = new ConditionDestructible();

    /**
     Destroys every permanent for whom ALL conditions are met.
     @param conditions conditions to meet
     */
    public static void destroyAll(Condition[] conditions, Card source) {
        for (int x = 0; x < battlefield.size(); x++) {
            if (destroyAllConditions(battlefield.get(x), conditions, source)) {
                destroyPermanent(battlefield.get(x));
            }
        }
    }

    public static boolean destroyAllConditions(Permanent target, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(target);
        }
        allConditionsMet &= destroyConditions(target, source);

        return allConditionsMet;
    }

    public static void destroyTarget(Permanent permanent, Condition[] conditions, Card source) {
        if (destroyTargetConditions(permanent, conditions, source)) {
            destroyPermanent(permanent);
        }
    }

    public static boolean destroyTargetConditions(Permanent permanent, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }

        allConditionsMet &= destroyConditions(permanent, source);

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

    public static boolean destroyTargetsConditions(Permanent[] permanents, Condition[] conditions, Card source) {
        boolean allConditionsMet = true;
        for (Permanent permanent : permanents) {
            allConditionsMet &= destroyTargetConditions(permanent, conditions, source);
        }
        return allConditionsMet;
    }

    private static boolean destroyConditions(Permanent target, Card source) {
        boolean destroyConditionsMet = true;
        destroyConditionsMet &= destructible.evaluate(target);
        //destructible by type
        //destructible by subtype
        destroyConditionsMet &= new ConditionVulnerableColor(source.colors).evaluate(target);
        return destroyConditionsMet;
    }

    private static void destroyPermanent(Permanent target) {
        battlefield.remove(target);
        target.resetModifiers();
        graveyard.get(target.ownerID).sendToGraveyard(target);
    }
}
