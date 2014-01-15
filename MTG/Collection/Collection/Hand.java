package Collection;

import Card.Card;

public class Hand extends Collection<Card> {
    public Card[] reveal() {
        return (Card[]) collection.toArray();
    }
}
