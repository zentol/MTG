package Action;

import Card.Permanent;
import static Game.Game.battlefield;

public class PutIntoPlay {
    public static void putIntoPlay(Permanent target) {
        battlefield.add(target);
    }
}
