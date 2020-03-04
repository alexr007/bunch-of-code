package s0200303;

import java.util.stream.IntStream;

public class ItApp {
  public static void main(String[] args) {
    // JDK 8
    IntStream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
    // JDK 9
//    IntStream.iterate(10, i -> i < 15, i -> i + 1).forEach(System.out::println);

  }
}
