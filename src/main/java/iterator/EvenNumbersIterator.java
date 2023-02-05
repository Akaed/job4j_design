package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private  int index;
    private int count;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
       boolean countboolean = false;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                countboolean = true;
                break;
            }
        }
        return countboolean;
    }

    @Override
    public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }


        return data[index++];
    }
}
