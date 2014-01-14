package Collection;

import Card.Card;

public class Graveyard extends Staple {
    public void sendToGraveyard(Card p){
        this.collection.add(p);
    }
}
