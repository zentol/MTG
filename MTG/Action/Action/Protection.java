package Action;

import Action.Action;
import Card.Card;
import Card.Permanent;
import Effect.Type.Static.StaticInvulnerableColor;
import Effect.Type.Static.StaticUntargetableColor;

public abstract class Protection extends Action {

    public static void addInvulnerablityColor(Card source, Permanent target, int color) {
        target.modifiers.add(new StaticInvulnerableColor(source, target, color));
    }
    
    public static void addUntargetableColor(Card source, Permanent target, int color) {
        target.modifiers.add(new StaticUntargetableColor(source, target, color));
    }
}
