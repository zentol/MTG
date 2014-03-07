package Action;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Condition.Permanent.ConditionTargetable;
import Game.InvalidTargetException;

public class Target {
    private static ConditionTargetable targetable;

    public static void target(Card target, Card source) {
        targetCondition(target, source);
    }

    public static void target(Card[] targets, Card source) {
        for (Card target : targets) {
            targetCondition(target, source);
        }
    }

    private static void targetCondition(Card target, Card source) {
        targetable = new ConditionTargetable(true, source);
        boolean targetConditionsMet = true;
        targetConditionsMet &= targetable.evaluate(target);
        if (!targetConditionsMet) {
            throw new InvalidTargetException();
        }
    }

//------------------------------------------------------------------------------
    public static int validateTargets(Permanent[] permanents, Condition[] conditions, Card source) {
        int validTargets = 0;
        for (Permanent permanent : permanents) {
            if (checkConditions(permanent, conditions)) {
                validTargets++;
            }
        }
        return validTargets;
    }
}
