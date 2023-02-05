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

        for(int i = index; i < data.length; i++){
            index++;
            if (data[i] % 2 == 0) {
               return  true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {

            if (data.length == 0) {
                throw new NoSuchElementException();
            }

        for(int i = count; i < data.length; i++){
            count++;
            if(data[i] % 2 == 0) {
                return data[i];
            }
        }

        return 1;
    }
}
