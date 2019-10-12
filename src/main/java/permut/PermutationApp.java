package permut;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationApp {
    public static void main(String[] args) {
        List<XPair> collect = IntStream.range(1, 6).boxed()
                .flatMap(p1 -> IntStream.range(p1 + 1, 6).mapToObj(p2 -> new XPair(p1, p2)))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
