package Collection;

import Effect.Effect;
import Effect.Resolve.Resolve;

public class Stack extends Collection<Effect> {

    public void resolveStack() {
        while (collection.size() > 0) {
            ((Resolve) collection.remove(collection.size() - 1)).execute();
        }
    }

}
