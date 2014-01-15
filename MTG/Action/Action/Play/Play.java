package Action.Play;

import Action.Action;
import Card.Card;
import Effect.Resolve.Resolve;
import static Game.Game.activePlayer;
import static Game.Game.manapool;
import static Game.Game.stack;

public class Play extends Action {
    public static void play(Card target) {
        if (manapool.get(activePlayer).contains(target.cost)) {
            manapool.get(activePlayer).useMana(target.cost);
            stack.add(new Resolve(target));
        }
    }
}
