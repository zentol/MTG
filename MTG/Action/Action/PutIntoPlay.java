package Action;

import static Action.FireEvent.fireEvent;
import Card.Permanent;
import Ability.Ability;
import static Ability.Ability.KEY_ABILITY_TYPE_STATIC;
import Event.EventEnterTheBattlefield;
import static Game.Game.battlefield;

public class PutIntoPlay {
    public static void putIntoPlay(Permanent target) {
        battlefield.add(target);
        for (Ability effect : target.abilities) {
            if (effect.getType() == KEY_ABILITY_TYPE_STATIC) {
                effect.execute();
            }
        }
        fireEvent(new EventEnterTheBattlefield(target));
    }
}
