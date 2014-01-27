package Collection;

import Card.Card;

public class Hand extends Collection<Card> {
    public int cardLimit = 7;

    public Card[] reveal() {
        Card[] revealedCards = new Card[collection.size()];
        for (int x = 0; x < collection.size(); x++) {
            revealedCards[x] = collection.get(x);
        }
        return revealedCards;
    }
}
