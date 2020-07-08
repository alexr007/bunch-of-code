package kata13.count;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class LineCounter {
  public final File file;

  public LineCounter(File file) {
    this.file = file;
  }

  static <C, A> A fold(Iterable<C> data, A initial, BiFunction<A, C, A> f) {
    Iterator<C> it = data.iterator();
    return fold(it, initial, f);
  }

  static <C, A> A fold(Iterator<C> it, A initial, BiFunction<A, C, A> f) {
    A acc = initial;
    while (it.hasNext()) acc = f.apply(acc, it.next());
    return acc;
  }

  static class Step {
    public final int count;
    public final boolean block;

    Step(int count, boolean block) {
      this.count = count;
      this.block = block;
    }

    static Step zero() {
      return new Step(0, false);
    }
  }

  static Step fold_fn(Step acc, String line) {
    return new Step(acc.count + 1, false);
  }

  @SneakyThrows
  public long simple() {
    try (Stream<String> stream = Files.lines(file.toPath())) {
      return fold(stream.iterator(), Step.zero(), LineCounter::fold_fn)
          .count;
    }
  }
}
