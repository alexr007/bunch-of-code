package so200219;

import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Before<T, R> extends Function<Consumer<T>, Function<Function<T, R>, Function<T, R>>> {

  static <T, R> Before<T, R> create() {
    return before -> function -> argument -> {
      before.accept(argument);
      return function.apply(argument);
    };
  }

  static <T, R> Function<T, R> decorate(Consumer<T> before, Function<T, R> function) {
    return Before.<T, R>create().apply(before).apply(function);
  }

}
