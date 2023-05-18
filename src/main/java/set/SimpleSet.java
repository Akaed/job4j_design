package set;

import collection.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        boolean count = false;
        if (!contains(value)) {
            set.add(value);
            count = true;
        }
        return count;
    }

    @Override
    public boolean contains(T value) {
        boolean count = false;
        for (T element : set) {
            if (Objects.equals(element, value)) {
                count = true;
                break;
            }
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
