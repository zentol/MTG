package Collection;

import Card.Card;
import java.util.ArrayList;
import java.util.Random;

public class Library extends Staple {
    public Card[] draw(int count) {
        Card[] cards = new Card[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.remove(0);
        }
        return cards;
    }

    public void shuffle() {
        ArrayList<Card> libraryCopy = (ArrayList<Card>) collection.clone();
        Random cardPicker = new Random();
        for (int x = 0; x < collection.size(); x++) {
            collection.set(x, libraryCopy.remove(cardPicker.nextInt(libraryCopy.size())));
        }
    }

}
