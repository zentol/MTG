
package Action;

import Card.Permanent;
import Condition.Condition;
import static Game.Game.battlefield;

public class Tap {
    
    public static void tapAll(Condition[] conditions) {
        for (int x = 0; x < battlefield.size(); x++) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(battlefield.get(x));
            }
            allConditionsMet &= tapConditions(battlefield.get(x), null);

            if (allConditionsMet) {
                battlefield.get(x).tap();
            }
        }
    }

    public static void tapTarget(Permanent permanent, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }

        allConditionsMet &= tapConditions(permanent, null);

        if (allConditionsMet) {
            permanent.tap();
        }
    }

    public static void tapTargets(Permanent[] permanents, Condition[] conditions) {
        for (Permanent permanent : permanents) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(permanent);
            }

            allConditionsMet &= tapConditions(permanent, null);

            if (allConditionsMet) {
                permanent.tap();
            }
        }
    }
    
    private static boolean tapConditions(Permanent target, Permanent source){
        return true;
    }
    
    public static void untapAll(Condition[] conditions) {
        for (int x = 0; x < battlefield.size(); x++) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(battlefield.get(x));
            }
            allConditionsMet &= untapConditions(battlefield.get(x), null);

            if (allConditionsMet) {
                battlefield.get(x).untap();
            }
        }
    }

    public static void untapTarget(Permanent permanent, Condition[] conditions) {
        boolean allConditionsMet = true;
        for (Condition condition : conditions) {
            allConditionsMet &= condition.evaluate(permanent);
        }

        allConditionsMet &= untapConditions(permanent, null);

        if (allConditionsMet) {
            permanent.untap();
        }
    }

    public static void untapTargets(Permanent[] permanents, Condition[] conditions) {
        for (Permanent permanent : permanents) {
            boolean allConditionsMet = true;
            for (Condition condition : conditions) {
                allConditionsMet &= condition.evaluate(permanent);
            }

            allConditionsMet &= untapConditions(permanent, null);

            if (allConditionsMet) {
                permanent.untap();
            }
        }
    }
    
    private static boolean untapConditions(Permanent target, Permanent source){
        return true;
    }


}
