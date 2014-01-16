package Collection;

import Card.Card;

public class Graveyard extends Staple {
    public void sendToGraveyard(Card target) {
        this.collection.add(target);
    }
}
