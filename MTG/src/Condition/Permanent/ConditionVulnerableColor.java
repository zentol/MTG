package Condition.Permanent;

import Card.Permanent;
import Condition.Condition;
import Effect.Type.Static.StaticProtectionColor;

public class ConditionVulnerableColor extends Condition<Permanent> {
    private final String colors;

    public ConditionVulnerableColor(String colors) {
        this.colors = colors;
    }

    @Override
    public boolean evaluate(Permanent target) {
        for (int x = 0; x < target.modifiers.size(); x++) {
            if (target.modifiers.get(x).getClass().equals(StaticProtectionColor.class)) {
                return !((StaticProtectionColor) target.modifiers.get(x)).protectsAgainst(colors);
            }
        }
        return true;
    }
}
