package flatmap;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PermutationApp {
  private static Stream<Integer> range(int a, int b) {
    return IntStream.rangeClosed(a, b).boxed();
  }

  public static void main(String[] args) {
    range(1, 6).flatMap(v1 ->
        range(1, 6).flatMap(v2 ->
            Stream.of(XPair.of(v1, v2))))
        .filter(xp -> xp.v1() != xp.v2())
        .forEach(System.out::println);
  }
}
