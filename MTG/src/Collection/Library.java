package Collection;

import Card.Card;

public class Library extends Staple {
    public Card[] draw(int count) {
        Card[] cards = new Card[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.remove(0);
        }
        return cards;
    }

    public void shuffle() {
    }

}
