package Collection;

import Card.Card;

public class Exile extends Staple {
    public void sendToExile(Card target) {
        this.collection.add(target);
    }
}
