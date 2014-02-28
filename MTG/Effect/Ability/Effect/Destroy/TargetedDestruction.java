package Ability.Effect.Destroy;

import Ability.SpellAbility;
import static Action.Destroy.destroyTarget;
import static Action.Target.target;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import static Condition.Condition.checkConditions;
import Game.InvalidTargetException;

public class TargetedDestruction extends SpellAbility {
    private final Condition[] conditions;
    private Card target;

    public TargetedDestruction(int targets, Condition[] conditions) {
        super(targets);
        this.conditions=conditions;
    }

    @Override
    public void activate(Card[] targets) {
        target = targets[0];
        target(target, source);
        if (!checkConditions((Permanent) target, conditions)) {
            throw new InvalidTargetException();
        }
    }

    @Override
    public void execute() {
        try {
            destroyTarget((Permanent) target, conditions, source);
        } catch (InvalidTargetException ITE) {
            //counter(this);
        }
    }

    @Override
    public void payCost() {
    }
}
