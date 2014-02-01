package Action;

import static Action.Pay.payMana;
import Card.Card;
import Effect.Effect;
import Effect.Resolve.ResolvePermanent;
import Effect.Resolve.ResolveSpell;
import static Game.Game.activePlayer;
import static Game.Game.manapool;
import static Game.Game.stack;

public abstract class Play extends Action {
    public static void playCard(Card target) {
        if (manapool.get(activePlayer).contains(target.cost)) {
            payMana(target.cost);
            if (target.isSpell()) {
                stack.add(new ResolveSpell(target));
            }
            if (target.isPermanent()) {
                stack.add(new ResolvePermanent(target));
            }
        }
    }

    public static void playAbility(Effect effect) {
        //if valid play
        //if cost paid
        addEffectToStack(effect);
    }

    private static void addEffectToStack(Effect effect) {
        if (effect.targeting) {
            /*
             Card[] targets = selectTargets();
             effect.activate(targets);
             */
        }
        stack.add(effect);
    }
}
