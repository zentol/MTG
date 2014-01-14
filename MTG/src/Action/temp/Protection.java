package Action.temp;

import Action.Action;
import Card.Card;
import Card.Permanent;
import Effect.Type.Static.StaticProtectionColor;

public class Protection extends Action {

    public static void addProtectionColor(Card source, Permanent target, String color) {
        target.modifiers.add(new StaticProtectionColor(source, target, color));
    }
}
