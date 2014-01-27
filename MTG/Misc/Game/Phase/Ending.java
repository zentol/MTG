package Game.Phase;

import static Action.Discard.discard;
import Card.Card;
import static Game.Game.activePlayer;
import static Game.Game.hand;

public class Ending {
    public static void phaseEnding() {
        stepEnd();
        stepCleanup();
    }

    private static void stepEnd() {
        triggerBeginningEndStep();
        triggerBeginningNextEndStep();
    }

    private static void stepCleanup() {
        discardCards();
        //simoultaneously
        removeAllDamage();
        finishUntilEndOfTurn();
    }
    
    private static void discardCards(){
        if(hand.get(activePlayer).size()>hand.get(activePlayer).cardLimit){
            Card[] toDiscard = selectCards(hand.get(activePlayer).size()-hand.get(activePlayer).cardLimit);
            discard(toDiscard);
        }
    }
}
