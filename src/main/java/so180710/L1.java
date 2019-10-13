package so180710;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L1 {
    public static void main0(String[] args) {
        Map<String, Integer> c02 = Arrays.asList(
                "103S2", "106S2", "109S2", "112S2", "115S2", "118S2", "121S2", "124S2", "127S2", "130S2", "133S2", "136S2")
                .stream()
                .collect(
                        Collectors.toMap(s -> {
                            return s.split("S")[0]; // here i get error "cannot resolve split"
                        }, s -> {
                            String s1 = s.split("S")[1];
                            return Integer.parseInt(s1);
                        }));
        System.out.println(c02);
    }

    public static void main(String[] args) {
        class Pair {
            private final int k;
            private final int v;

            Pair(String raw) {
                this(raw.split("S"));
            }

            Pair(String[] raw) {
                this(raw[0], raw[1]);
            }

            Pair(String k, String v) {
                this(Integer.parseInt(k), Integer.parseInt(v));
            }

            Pair(int k, int v) {
                this.k = k;
                this.v = v;
            }

            public int getK() {
                return this.k;
            }

            public int getV() {
                return this.v;
            }
        }

        Map<Integer, Integer> collect = Stream.of(
                "103S2", "106S2", "109S2", "112S2", "115S2", "118S2", "121S2", "124S2", "127S2", "130S2", "133S2", "136S2")
                .map(Pair::new)
                .collect(Collectors.toMap(Pair::getK, Pair::getV));
        System.out.println(collect);
    }
}
