package Action;

import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Game.InvalidTargetException;
import Modifier.Protection.TargetingModifier;

public class Target {

    public static void target(Card target, Card source) {
        targetCondition(target, source);
    }

    private static void targetCondition(Card target, Card source) {
        boolean targetConditionsMet = true;

        for (int x = 0; x < target.modifiers.size(); x++) {
            if (TargetingModifier.class.isInstance(target.modifiers.get(x))) {
                targetConditionsMet &= !((TargetingModifier) target.modifiers.get(x)).preventsTargeting(source);
            }

        }
        //check subtype
        if (!targetConditionsMet) {
            throw new InvalidTargetException();
        }
    }
    public static int validateTargets(Permanent[] permanents, Condition[] conditions, Card source) {
        int validTargets = 0;
        for (Permanent permanent : permanents) {
            if (checkConditions(permanent, conditions, source)) {
                validTargets++;
            }
        }
        return validTargets;
    }
}
