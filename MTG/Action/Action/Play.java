package Action;

import static Action.Pay.payMana;
import static Action.Select.select;
import Card.Card;
import Ability.Ability;
import Ability.Resolve.ResolvePermanent;
import Ability.Resolve.ResolveSpell;
import static Game.Game.activePlayer;
import static Game.Game.manapool;
import static Game.Game.stack;

public abstract class Play {
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

    public static void playAbility(Ability effect) {
        //if valid play
        //if cost paid
        addEffectToStack(effect);
    }

    private static void addEffectToStack(Ability effect) {
        if (effect.targetCount > 0) {

            Card[] targets = select(1);
            effect.activate(targets);

        } else {
            effect.activate(new Card[0]);
        }
        stack.add(effect);
    }
}
