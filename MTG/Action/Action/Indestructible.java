package Action;

import Card.Permanent;
import Ability.Ability;
import Modifier.Damaging.ModifierIndestructible;

public abstract class Indestructible {

    public static void addIndestructible(Ability source, Permanent target) {
        target.modifiers.add(new ModifierIndestructible(target, source));
    }
}
