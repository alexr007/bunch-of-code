package so200303;

import java.util.Optional;
import java.util.stream.IntStream;

public class ItApp {

  static class Flight {
    public final String name;
    public final int number;

    Flight(String name, int number) {
      this.name = name;
      this.number = number;
    }

    public String represent() {
      return String.format("'%s - %n'", name, number);
    }

  }

  public static void main(String[] args) {
    // JDK 8
    IntStream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
    // JDK 9
//    IntStream.iterate(10, i -> i < 15, i -> i + 1).forEach(System.out::println);
    Optional<Flight> f = Optional.of(new Flight("KL", 315));
    String s = f.map(Flight::represent).orElse("");
    System.out.println(s);
  }
}
