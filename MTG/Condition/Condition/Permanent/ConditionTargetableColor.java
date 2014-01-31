
package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Protection.ModifierUntargetableColor;

public class ConditionTargetableColor extends Condition<Permanent> {
    private final int colors;

    public ConditionTargetableColor(int colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (target.modifiers.get(x).getClass().equals(ModifierUntargetableColor.class)) {
                return !((ModifierUntargetableColor) target.modifiers.get(x)).protectsAgainst(colors);
            }
        }
        return true;
    }
}
