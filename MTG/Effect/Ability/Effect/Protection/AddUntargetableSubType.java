package Ability.Effect.Protection;

import Ability.Ability;
import Ability.Cost;
import static Action.Protection.addUntargetableSubType;
import Card.Card;
import Card.Permanent;
import Condition.Condition;
import Trigger.Trigger;

public class AddUntargetableSubType extends Ability {
    private final String[] subTypes;

    public AddUntargetableSubType(String[] subTypes, int targets, int type, Cost cost, Trigger trigger, Condition... conditions) {
        super(targets, type, conditions, cost, trigger);
        this.subTypes = subTypes;
    }

    @Override
    protected void executeActions(Card target) {
        addUntargetableSubType(this, (Permanent) target, subTypes);
    }
}
