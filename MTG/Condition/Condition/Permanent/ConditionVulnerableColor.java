package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Modifier.Protection.ModifierInvulnerableColor;

public class ConditionVulnerableColor extends Condition<Permanent> {
    private final int colors;

    public ConditionVulnerableColor(int colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (target.modifiers.get(x).getClass().equals(ModifierInvulnerableColor.class)) {
                return !((ModifierInvulnerableColor) target.modifiers.get(x)).protectsAgainst(colors);
            }
        }
        return true;
    }
}
