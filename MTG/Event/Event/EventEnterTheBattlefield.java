package Event;

import Card.Permanent;

public class EventEnterTheBattlefield extends Event {
    private final Permanent target;

    public EventEnterTheBattlefield(Permanent target) {
        super(KEY_EVENT_ETB);
        this.target = target;
    }
    
    public Permanent getTarget(){
        return target;
    }
}
