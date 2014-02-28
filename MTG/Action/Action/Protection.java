package Action;

import Card.Permanent;
import Ability.Ability;
import Modifier.Damaging.ModifierInvulnerableColor;
import Modifier.Targeting.ModifierUntargetableColor;
import Modifier.Targeting.ModifierUntargetableSubType;

public abstract class Protection {

    public static void addInvulnerablityColor(Ability source, Permanent target, int color) {
        target.modifiers.add(new ModifierInvulnerableColor(target, source, color));
    }

    public static void addUntargetableColor(Ability source, Permanent target, int color) {
        target.modifiers.add(new ModifierUntargetableColor(target, source, color));
    }

    public static void addUntargetableSubType(Ability source, Permanent target, String[] subTypes) {
        target.modifiers.add(new ModifierUntargetableSubType(target, source, subTypes));
    }
}
