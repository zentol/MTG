package Ability.Effect.Protection;

import Ability.Ability;
import Ability.Cost;
import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class AddUntargetableAspect extends Ability {
    private final int aspect;

    public AddUntargetableAspect(int aspect, int targets, int type, Cost cost, Trigger trigger, Condition... conditions) {
        super(targets, type, conditions, cost, trigger);
        this.aspect=aspect;
    }

    @Override
    protected void executeActions(Card target) {
        addUntargetableColor(this, (Permanent) target, aspect);
    }
}
