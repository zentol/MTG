package Action;

import Ability.Ability;
import static Ability.Ability.KEY_ABILITY_TYPE_TRIGGERED;
import Event.Event;
import static Game.Game.battlefield;

public class FireEvent {
    public static void fireEvent(Event event) {
        for (int x = 0; x < battlefield.size(); x++) {
            for (Ability effect : battlefield.get(x).abilities) {
                if (effect.getType() == KEY_ABILITY_TYPE_TRIGGERED) {
                    effect.evaluateTrigger(event);
                }
            }
        }
    }
}
