package Ability.Effect.Protection;

import Ability.Ability;
import Ability.Cost;
import static Action.Protection.addInvulnerablityColor;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class AddInvulnerableColor extends Ability {
    private final int color;

    public AddInvulnerableColor(int color, int targets, int type, Cost cost, Trigger trigger, Condition... conditions) {
        super(targets, type, conditions, cost, trigger);
        this.color = color;
    }

    @Override
    protected void executeActions(Card target) {
        addInvulnerablityColor(this, (Permanent) target, color);
    }
}
