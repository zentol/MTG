package Action;

import Card.Card;
import Card.Permanent;
import Modifier.Protection.ModifierInvulnerableColor;
import Modifier.Protection.ModifierUntargetableColor;
import Modifier.Protection.ModifierUntargetableSubType;

public abstract class Protection {

    public static void addInvulnerablityColor(Card source, Permanent target, int color) {
        target.modifiers.add(new ModifierInvulnerableColor(source, color));
    }

    public static void addUntargetableColor(Card source, Permanent target, int color) {
        target.modifiers.add(new ModifierUntargetableColor(source, color));
    }

    public static void addUntargetableSubType(Card source, Permanent target, String[] subTypes) {
        target.modifiers.add(new ModifierUntargetableSubType(source, subTypes));
    }
}
