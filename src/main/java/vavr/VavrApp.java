package vavr;

import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;

import java.util.function.Function;

public class VavrApp {
  public Option<Integer> toInt(String origin) {
    try {
      return Option.of(Integer.parseInt(origin));
    } catch (NumberFormatException ex) {
      return Option.none();
    }
  }

  public Either<String, Integer> toInt_(String origin) {
    try {
      return Either.right(Integer.parseInt(origin));
    } catch (NumberFormatException ex) {
      return Either.left("Conversion error");
    }
  }

  public static void main1(String[] args) {
    List.of(1,2,3,4,5,6,7,8)
        .filter(x -> x < 5)
        .map(x -> x * 2)
        .flatMap(x -> List.of(-x, x))
        .forEach(System.out::println);

    VavrApp app = new VavrApp();
    Either<String, Integer> conversion_error = app.toInt("33").toEither("conversion error");
  }

  public static void main(String[] args) {
    VavrApp app = new VavrApp();
    Either<String, Integer> integers1 = app.toInt_("111");
    Either<String, Integer> integers2 = app.toInt_("111ass");
    String fold = integers1.fold(new Function<String, String>() {
      @Override
      public String apply(String s) {
        return "Error:" + s;
      }
    }, new Function<Integer, String>() {
      @Override
      public String apply(Integer integer) {
        return "OK:" + integer;
      }
    });
  }

}
