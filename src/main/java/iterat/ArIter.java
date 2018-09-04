package iterat;

import java.util.Iterator;

public class ArIter implements Iterable<Integer>{
    private final int[] a;

    class Iter implements Iterator<Integer> {
        private int pos;

        @Override
        public boolean hasNext() {
            return pos<a.length;
        }

        @Override
        public Integer next() {
            return a[pos++];
        }
    }

    public ArIter() {
        this.a = new int[10];
        for (int i = 0; i < this.a.length; i++) {
            a[i]=i*10;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iter();
    }

    public static void main(String[] args) {
        ArIter a = new ArIter();
        for (int el : a) {
            System.out.println(el);
        }
    }

}
