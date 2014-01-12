package Action.Destroy;

import Action.Action;
import Card.Permanent;
import Condition.Condition;
import static Game.Game.*;
import static Game.Game.graveyard;

public class Destroy extends Action {
    public static void destroyAll(Condition[] conditions) {
        for (int x = 0; x < battlefield.size(); x++) {
            boolean allConditionsMet = true;
            for (int y = 0; x < conditions.length; y++) {
                allConditionsMet &= conditions[y].evaluate(battlefield.get(x));

            }
            if (allConditionsMet) {
                destroyPermanent(battlefield.get(x));
            }
        }
    }

    private static void destroyPermanent(Permanent p) {
        battlefield.remove(p);
        graveyard.get(p.ownerID).sendToGraveyard(p);
    }
}
