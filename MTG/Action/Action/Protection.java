package Action;

import Card.Card;
import Card.Permanent;
import Modifier.Protection.ModifierInvulnerableColor;
import Modifier.Protection.ModifierUntargetableColor;

public abstract class Protection extends Action {

    public static void addInvulnerablityColor(Card source, Permanent target, int color) {
        target.modifiers.add(new ModifierInvulnerableColor(source, color));
    }

    public static void addUntargetableColor(Card source, Permanent target, int color) {
        target.modifiers.add(new ModifierUntargetableColor(source, color));
    }
}
