package Action.Play;

import Action.Action;
import Card.Card;
import Effect.Resolve.Resolve;
import static Game.Game.stack;

public class Play extends Action {
    public static void play(Card target) {
        stack.add(new Resolve(target));
    }
}
