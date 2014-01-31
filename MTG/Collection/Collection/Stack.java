package Collection;

import Effect.Effect;

public class Stack extends Collection<Effect> {

    public void resolveStack() {
        while (collection.size() > 0) {
            collection.remove(collection.size() - 1).execute();
        }
    }

}
