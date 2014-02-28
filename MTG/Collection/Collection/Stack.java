package Collection;

import Ability.Ability;

public class Stack extends Collection<Ability> {

    public void resolveStack() {
        while (collection.size() > 0) {
            collection.remove(collection.size() - 1).execute();
        }
    }

}
