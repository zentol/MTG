package Collection;

import Card.Proxy;

public abstract class Staple extends Collection<Proxy> {

    public void putOnTop(Proxy[] cards) {
        for (int x = cards.length - 1; x > 0; x--) {
            collection.add(0, cards[x]);
        }
    }

    public void putOnBottom(Proxy[] cards) {
        for (int x = 0; x < cards.length; x--) {
            collection.add(cards[x]);
        }
    }

    public void putRandom(Proxy[] cards) {

    }

    public Proxy[] look(int count) {
        Proxy[] cards = new Proxy[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.get(x);
        }
        return cards;
    }
}
