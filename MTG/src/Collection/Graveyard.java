package Collection;

import Card.Proxy;

public class Graveyard extends Staple {
    public void sendToGraveyard(Proxy p){
        this.collection.add(p);
    }
}
