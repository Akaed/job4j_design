package set;

import collection.SimpleArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private static final Object PRESENT = new Object();
    private SimpleArrayList<T> set = new SimpleArrayList<>(0);
    private HashMap<T, T> map = new HashMap();

    @Override
    public boolean add(T value) {
        return map.put(value, (T) PRESENT) == null;
    }

    @Override
    public boolean contains(T value) {
        return Objects.equals(set.iterator(), value);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
