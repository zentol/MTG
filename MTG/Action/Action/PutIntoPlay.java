package Action;

import static Action.FireEvent.fireEvent;
import Card.Permanent;
import Event.EventEnterTheBattlefield;
import static Game.Game.battlefield;

public class PutIntoPlay {
    public static void putIntoPlay(Permanent target) {
        battlefield.add(target);
        fireEvent(new EventEnterTheBattlefield(target));
    }
}
