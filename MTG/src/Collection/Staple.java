package Collection;

import Card.Card;

public abstract class Staple extends Collection<Card> {

    public void putOnTop(Card[] cards) {
        for (int x = cards.length - 1; x > 0; x--) {
            collection.add(0, cards[x]);
        }
    }

    public void putOnBottom(Card[] cards) {
        for (int x = 0; x < cards.length; x--) {
            collection.add(cards[x]);
        }
    }

    public void putRandom(Card[] cards) {

    }

    public Card[] look(int count) {
        Card[] cards = new Card[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.get(x);
        }
        return cards;
    }
}
