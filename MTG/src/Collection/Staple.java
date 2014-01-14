package Collection;

import Card.Card;
import java.util.ArrayList;
import java.util.Random;

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
        Random positionPicker = new Random();
        for (Card card : cards) {
            collection.add(positionPicker.nextInt(collection.size()), card);
        }
    }

    public Card[] look(int count) {
        Card[] cards = new Card[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.get(x);
        }
        return cards;
    }
    
    public void shuffle() {
        ArrayList<Card> collectionCopy = (ArrayList<Card>) collection.clone();
        Random cardPicker = new Random();
        for (int x = 0; x < collection.size(); x++) {
            collection.set(x, collectionCopy.remove(cardPicker.nextInt(collectionCopy.size())));
        }
    }
}
