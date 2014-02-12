package Event;

public abstract class Event {
    public static final int KEY_EVENT_ETB = 1;
    private final int type;

    public Event(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
