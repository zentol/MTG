package Action.Draw;

import Action.Action;
import Card.Card;
import static Game.Game.activePlayer;
import static Game.Game.hand;
import static Game.Game.library;

public class Draw extends Action {
    public static void draw(int count) {
        Card[] drawnCards = library.get(activePlayer).draw(count);
        for (Card drawnCard : drawnCards) {
            hand.get(activePlayer).add(drawnCard);
        }
    }

    public static void draw(int count, int playerID) {
        Card[] drawnCards = library.get(playerID).draw(count);
        for (Card drawnCard : drawnCards) {
            hand.get(playerID).add(drawnCard);
        }
    }
}
