package Action;

import Effect.Effect;
import static Effect.Effect.KEY_EFFECT_TYPE_TRIGGERED;
import Effect.TriggeredEffect;
import Event.Event;
import static Game.Game.battlefield;

public class FireEvent {
    public static void fireEvent(Event event) {
        for (int x = 0; x < battlefield.size(); x++) {
            for (Effect effect : battlefield.get(x).effects) {
                if (effect.getType() == KEY_EFFECT_TYPE_TRIGGERED) {
                    ((TriggeredEffect) effect).evaluateTrigger(event);
                }
            }
        }
    }
}
