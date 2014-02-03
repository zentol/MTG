package Action;

import Card.Permanent;
import Effect.Effect;
import Modifier.Damaging.ModifierInvulnerableColor;
import Modifier.Targeting.ModifierUntargetableColor;
import Modifier.Targeting.ModifierUntargetableSubType;

public abstract class Protection {

    public static void addInvulnerablityColor(Effect source, Permanent target, int color) {
        target.modifiers.add(new ModifierInvulnerableColor(source, color));
    }

    public static void addUntargetableColor(Effect source, Permanent target, int color) {
        target.modifiers.add(new ModifierUntargetableColor(source, color));
    }

    public static void addUntargetableSubType(Effect source, Permanent target, String[] subTypes) {
        target.modifiers.add(new ModifierUntargetableSubType(source, subTypes));
    }
}
