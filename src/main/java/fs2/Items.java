package fs2;

import java.util.Iterator;

public class Items implements Iterable<Integer>{
    private final int[] data = {1,2,3};

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < data.length;
            }

            @Override
            public Integer next() {
                return data[pos++];
            }
        };
    }
}
