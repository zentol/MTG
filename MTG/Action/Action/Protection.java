package Action;

import Action.Action;
import Card.Card;
import Card.Permanent;
import Effect.Type.Static.StaticProtectionColor;

public abstract class Protection extends Action {

    public static void addProtectionColor(Card source, Permanent target, String color) {
        target.modifiers.add(new StaticProtectionColor(source, target, color));
    }
}
