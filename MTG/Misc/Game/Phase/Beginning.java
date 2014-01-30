package Game.Phase;

import Card.Permanent;
import static Game.Game.activePlayer;
import static Game.Game.hand;
import static Game.Game.library;

public class Beginning {
    public static void phaseBeginning() {
        stepUntap();
        stepUpkeep();
        stepDraw();
    }

    private static void stepUntap() {
        /*
         triggerPhaseInOut();
         Permanent[] toUntap = selectPermanents();
         untap(toUntap);
         */
    }

    private static void untap(Permanent[] permanents) {
        for (Permanent permanent : permanents) {
            permanent.untap();
        }
    }

    private static void stepUpkeep() {
        //triggerBeginningOfUpkeep();
        //triggerBeginningOfNextUpkeep();
    }

    private static void stepDraw() {
        drawCard();
        //triggerBeginningOfDraw();
    }

    private static void drawCard() {
        hand.get(activePlayer).add(library.get(activePlayer).draw(1));
    }

}
