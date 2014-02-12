package Effect.Type.Triggered.Trigger;

import Condition.Condition;
import static Condition.Condition.checkConditions;
import Event.Event;
import static Event.Event.KEY_EVENT_ETB;
import Event.EventEnterTheBattlefield;

public class EnterTheBattlefield extends Trigger {
    private Condition[] conditions;

    public EnterTheBattlefield(Condition[] conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean check(Event event) {
        if (event.getType() == KEY_EVENT_ETB) {
            return checkConditions(((EventEnterTheBattlefield) event).getTarget(), conditions, null);
        }
        return false;
    }
}
