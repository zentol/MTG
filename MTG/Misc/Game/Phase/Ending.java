package Game.Phase;

import static Card.Aspect.Aspect.KEY_ASPECT_CREATURE;
import Card.Aspect.Permanent.CreatureAspect;
import static Game.Game.activePlayer;
import static Game.Game.battlefield;
import static Game.Game.hand;

public class Ending {
    public static void phaseEnding() {
        stepEnd();
        stepCleanup();
    }

    private static void stepEnd() {
        //triggerBeginningEndStep();
        //triggerBeginningNextEndStep();
    }

    private static void stepCleanup() {
        discardCards();
        //simoultaneously
        removeAllDamage();
        //finishUntilEndOfTurn();
    }

    private static void discardCards() {
        if (hand.get(activePlayer).size() > hand.get(activePlayer).cardLimit) {
            /*
             Card[] toDiscard = selectCards(hand.get(activePlayer).size()-hand.get(activePlayer).cardLimit);
             discard(toDiscard);
             */
        }
    }

    private static void removeAllDamage() {
        for (int x = 0; x < battlefield.size(); x++) {
            if (battlefield.get(x).hasAspect(KEY_ASPECT_CREATURE)) {
                ((CreatureAspect) battlefield.get(x).getAspect(KEY_ASPECT_CREATURE)).clearDamage();
            }
        }
    }
}
