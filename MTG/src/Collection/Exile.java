package Collection;

import Card.Proxy;

public class Exile extends Staple {
    public void sendToExile(Proxy p){
        this.collection.add(p);
    }
}
