package codegym;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class CountOfCities {

    public static class DisjointSet {
        private int[] sets;

        public DisjointSet(int count) {
            sets = new int[count];
            for (int i = 0; i < count; i++) {
                sets[i] = i;
            }
        }

        void add(int from, int to) {
            int rootTo = root(to);
            int rootFrom = root(from);
            sets[rootFrom] = rootTo;
        }

        private int root(int item) {
            while (item != sets[item]) {
                item = sets[item];
            }
            return item;
        }

        public List<Integer> sets() {
            Arrays.stream(sets).forEach(new IntConsumer() {
                @Override
                public void accept(int value) {
                    System.out.printf("%d ",value);
                }
            });
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sets.length; i++) {
                int elem = sets[i];
                if (elem != sets[i]) {
                    int cnt = map.getOrDefault(elem, 0);
                    map.put(elem,++cnt);
                }
            }
            ArrayList<Integer> l = new ArrayList<>();
            map.forEach((k, v) -> l.add(v));
            return l;
        }
    }

    public static void main(String[] args) {
        String s = "6 5\n" +
                "0 1\n" +
                "0 2\n" +
                "1 2\n" +
                "2 3\n" +
                "4 5";
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(s);

        int V = in.nextInt();
        int E = in.nextInt();
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < E; i++) {
            ds.add(in.nextInt(), in.nextInt());
        }
        List<Integer> sets = ds.sets();
        sets.forEach(val -> System.out.println(val+" "));
    }
}
