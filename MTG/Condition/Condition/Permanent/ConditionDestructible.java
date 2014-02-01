package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Damaging.ModifierIndestructible;

public class ConditionDestructible extends Condition<Permanent> {

    @Override
    public boolean evaluate(Permanent target) {
        return !target.hasModifier(ModifierIndestructible.class);
    }

}
