package Action;

import static Action.Pay.payMana;
import Card.Card;
import Effect.Effect;
import Effect.Resolve.ResolveCard;
import Effect.Resolve.ResolveEffect;
import static Game.Game.activePlayer;
import static Game.Game.manapool;
import static Game.Game.stack;

public abstract class Play extends Action {
    public static void playCard(Card target) {
        if (manapool.get(activePlayer).contains(target.cost)) {
            payMana(target.cost);
            stack.add(new ResolveCard(target));
        }
    }

    public static void playAbility(Effect effect) {
        //if valid play
        //if cost paid
        stack.add(new ResolveEffect(effect));
    }
}
