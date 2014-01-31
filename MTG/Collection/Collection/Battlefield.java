package Collection;

import Card.Permanent;

public class Battlefield extends Collection<Permanent> {
    public void wipe(){
        collection.clear();
    }
}
