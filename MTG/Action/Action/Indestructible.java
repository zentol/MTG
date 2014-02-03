package Action;

import Card.Permanent;
import Effect.Effect;
import Modifier.Damaging.ModifierIndestructible;

public abstract class Indestructible {

    public static void addIndestructible(Effect source, Permanent target) {
        target.modifiers.add(new ModifierIndestructible(source));
    }
}
