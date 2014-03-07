package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Damaging.ModifierIndestructible;

public class ConditionDestructible extends Condition<Permanent> {
    private final boolean mode;

    public ConditionDestructible(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean evaluate(Permanent target) {
        return mode == !target.hasModifier(ModifierIndestructible.class);
    }

}
