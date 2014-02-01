package Action;

import Card.Card;
import Card.Permanent;
import Modifier.Protection.ModifierIndestructible;

public abstract class Indestructible {

    public static void addIndestructible(Card source, Permanent target) {
        target.modifiers.add(new ModifierIndestructible(source));
    }
}
