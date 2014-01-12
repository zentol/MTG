package Collection;

import Card.Proxy;

public class Hand extends Collection<Proxy> {
    public Proxy[] reveal() {
        return (Proxy[]) collection.toArray();
    }
}
