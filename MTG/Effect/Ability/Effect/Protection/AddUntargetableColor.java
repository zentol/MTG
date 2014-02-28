package Ability.Effect.Protection;

import Ability.Ability;
import Ability.Cost;
import static Action.Protection.addUntargetableColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class AddUntargetableColor extends Ability {
    private final int color;

    public AddUntargetableColor(int color, int targets, int type, Condition[] conditions, Cost cost, Trigger trigger) {
        super(targets, type, conditions, cost, trigger);
        this.color=color;
    }

    @Override
    protected void executeActions(Card target) {
        addUntargetableColor(this, (Permanent) target, color);
    }
}
