package vavr;

import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

public class VavrApp {
  public Option<Integer> toInt(String origin) {
    try {
      return Option.of(Integer.parseInt(origin));
    } catch (NumberFormatException ex) {
      return Option.none();
    }
  }

  public static void main(String[] args) {
    List.of(1,2,3,4,5,6,7,8)
        .filter(x -> x < 5)
        .map(x -> x * 2)
        .flatMap(x -> List.of(-x, x))
        .forEach(System.out::println);

    VavrApp app = new VavrApp();
    Either<String, Integer> conversion_error = app.toInt("33").toEither("conversion error");
  }

}
