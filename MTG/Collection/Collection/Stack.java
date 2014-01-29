package Collection;

import Effect.Effect;
import Effect.Resolve.ResolveCard;

public class Stack extends Collection<Effect> {

    public void resolveStack() {
        while (collection.size() > 0) {
            ((ResolveCard) collection.remove(collection.size() - 1)).execute();
        }
    }

}
