package Ability.Effect.Destroy;

import Ability.Ability;
import Ability.Cost;
import static Action.Destroy.destroyTarget;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Game.InvalidTargetException;
import Trigger.Trigger;

public class TargetedDestruction extends Ability {

    public TargetedDestruction(int targets, int type, Condition[] conditions, Cost cost, Trigger trigger) {
        super(targets, type, conditions, cost, trigger);
    }

    @Override
    protected void executeActions(Card target) {
        try {
            destroyTarget((Permanent) target, conditions, source);
        } catch (InvalidTargetException ITE) {
            //counter(this);
        }
    }
}
