package Action.Draw;

import Card.Proxy;
import static Game.Game.activePlayer;
import static Game.Game.hand;
import static Game.Game.library;

public class Draw {
    public static void draw(int count) {
        Proxy[] drawnCards = library.get(activePlayer).draw(count);
        for (Proxy drawnCard : drawnCards) {
            hand.get(activePlayer).add(drawnCard);
        }
    }

    public static void draw(int count, int playerID) {
        Proxy[] drawnCards = library.get(playerID).draw(count);
        for (Proxy drawnCard : drawnCards) {
            hand.get(playerID).add(drawnCard);
        }
    }
}
