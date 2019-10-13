package codewars.l8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {
  public static int findIt(int[] a) {
    return Arrays.stream(a).boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .filter(item -> item.getValue() % 2 == 1)
        .findFirst()
        .get()
        .getKey();
  }
}