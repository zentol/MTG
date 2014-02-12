package Effect.Type.Triggered.Trigger;

import Event.Event;

public abstract class Trigger {
    public abstract boolean check(Event event);
}
