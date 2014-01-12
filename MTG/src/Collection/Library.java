package Collection;

import Card.Proxy;
import java.util.ArrayList;

public class Library extends Staple {
    public Proxy[] draw(int count) {
        Proxy[] cards = new Proxy[count];
        for (int x = 0; x < count; x++) {
            cards[x] = collection.remove(0);
        }
        return cards;
    }

    public void shuffle() {
    }

}
