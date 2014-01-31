package Action;

import Game.InvalidTargetException;
import Card.Card;
import Card.Permanent;
import Condition.Permanent.ConditionTargetableAspect;
import Condition.Permanent.ConditionTargetableColor;

public class Target extends Action {

    public static void target(Card target, Card source) {
        targetCondition(target, source);
    }

    private static void targetCondition(Card target, Card source) {
        boolean targetConditionsMet = true;
        targetConditionsMet &= new ConditionTargetableColor(source.colors).evaluate((Permanent) target);

        int[] aspects = source.getAspects();
        for (int aspect : aspects) {
            targetConditionsMet &= new ConditionTargetableAspect(aspect).evaluate((Permanent) target);
        }
        //check type
        //check subtype
        if (false) {
            throw new InvalidTargetException();
        }
    }
}
