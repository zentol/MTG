package Collection;

import Card.Card;

public class Exile extends Staple {
    public void sendToExile(Card p){
        this.collection.add(p);
    }
}
