package Ability.Effect.Static;

import Ability.Ability;
import Ability.Cost;
import static Action.Tap.tapTarget;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class Tap extends Ability {

    public Tap(int targets, int type, Condition[] conditions, Cost cost, Trigger trigger) {
        super(targets, type, conditions, cost, trigger);
    }

    @Override
    protected void executeActions(Card target) {
        if (type == KEY_ABILITY_TYPE_STATIC) {
            ((Permanent) target).tap();
        } else {
            tapTarget((Permanent) target, conditions);
        }
    }
}
