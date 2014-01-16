package Collection;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Collection<E> {
    protected ArrayList<E> collection;
    public int ownerID;

    public Collection() {
        collection = new ArrayList();
    }

    public E get(int index) {
        return collection.get(index);
    }

    public void add(E item) {
        collection.add(item);
    }

    public void add(E[] items) {
        collection.addAll(Arrays.asList(items));
    }

    public int size() {
        return collection.size();
    }

    public void remove(E item) {
        collection.remove(item);
    }
}
