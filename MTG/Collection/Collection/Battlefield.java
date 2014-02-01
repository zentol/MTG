package Collection;

import Card.Permanent;

public class Battlefield extends Collection<Permanent> {

    public void removePlayer(int playerID) {
        for (Permanent permanent : collection) {
            collection.remove(permanent);
        }
    }
}
