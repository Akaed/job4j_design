package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        point = data.length > 0 ? data.length - 1 : data.length;
    }

    @Override
    public boolean hasNext() {
        return point < 0 ? false : true;
    }

    @Override
    public Integer next() {
        if (data.length == 0) {
            throw new NoSuchElementException();
        }
        return  data[point--];
    }
}

