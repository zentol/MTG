package Action.Discard;

import Action.Action;
import Card.Card;
import static Game.Game.activePlayer;
import static Game.Game.graveyard;
import static Game.Game.hand;

public class Discard extends Action {
    public static void discard(Card[] cards) {
        for (Card card : cards) {
            hand.get(activePlayer).remove(card);
            graveyard.get(activePlayer).sendToGraveyard(card);
        }
    }

    public static void discard(Card[] cards, int playerID) {
        for (Card card : cards) {
            hand.get(playerID).remove(card);
            graveyard.get(playerID).sendToGraveyard(card);
        }
    }
}
