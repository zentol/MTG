package Action;

import Action.Action;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Condition.Permanent.ConditionDestructible;
import Condition.Permanent.ConditionVulnerableColor;
import static Game.Game.*;

public abstract class Destroy extends Action {
    private static ConditionDestructible destructible = new ConditionDestructible();
    //private static ConditionTargetable targetable = new ConditionTargetable();

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
            allConditionsMet &= destroyConditions(battlefield.get(x), null);

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

        allConditionsMet &= destroyConditions(permanent, null);

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

            allConditionsMet &= destroyConditions(permanent, null);

            if (allConditionsMet) {
                destroyPermanent(permanent);
            }
        }
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
        graveyard.get(target.ownerID).sendToGraveyard(target);
    }
}
