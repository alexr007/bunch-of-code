package kata13.strip;

import lombok.SneakyThrows;
import kata13.strip.filter.*;
import kata13.strip.state.FileState;
import kata13.strip.state.LineState;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.function.BiFunction;

public class StripComments {

  // particular implementation
  private final Strip impl =
//      new Strip0Nothing(); // 61 lines
//      new Strip1BlankLines(); // 52 = 61 - 9 blank
//      new Strip2LineOnlyComments(); // 45 = 52 - 7 single lines
//      new Strip3BlockOnlyComments();  // 46 = 52 - 6 blocks
      new Strip4AllComments();  // 39 = 52 - 6 - 7

  public FileState fold_fn(FileState acc, String line) {
    LineState ls = LineState.fresh(line, acc.inBlock);
    while (ls.pos < ls.input.length()) {
      ls = impl.process(ls);
    }
    return acc.next(impl.count(ls.output), ls.inBlock);
  }

  public <A, C> A fold(Iterable<C> data, A zero, BiFunction<A, C, A> f) {
    return fold(data.iterator(), zero, f);
  }

  public <A, C> A fold(Iterator<C> it, A zero, BiFunction<A, C, A> f) {
    A r = zero;
    while (it.hasNext()) r = f.apply(r, it.next());
    return r;
  }

  @SneakyThrows
  public static void main(String[] args) {
    StripComments strip = new StripComments();
    URI uri = strip.getClass().getClassLoader().resources("Strip0.java")
        .findFirst()
        .orElseThrow()
        .toURI();
    Iterator<String> it = Files.lines(Paths.get(uri)).iterator();
    // initial state: count = 0, inBlock = false
    FileState zero = FileState.zero();
    // fold state by applying `fold_fn`
    long count = strip.fold(it, zero, strip::fold_fn).count;
    System.out.println(count);
  }

}
