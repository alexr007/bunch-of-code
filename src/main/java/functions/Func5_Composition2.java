package functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * initial thoughts about Java high-order functions
 */
public class Func5_Composition2 {

  public static void main(String[] args) {
    // procedural approach
    System.out.println("A");
    System.out.println("B");

    // functional approach. declaration
    Consumer<String> printer = s -> System.out.println(s);

    printer.accept("C");
    printer.accept("D");

    BiConsumer<String, String> composition = (s1, s2) -> {
      printer.accept(s1);
      printer.accept(s2);
    };

    composition.accept("E", "F");

    class Pair {
      public final Consumer<String> func;
      public final String value;

      Pair(Consumer<String> func, String value) {
        this.func = func;
        this.value = value;
      }
    }

    class Composition {
      private final Collection<Pair> chain = new LinkedList<>();

      public Composition chain(Consumer<String> item, String value) {
        chain.add(new Pair(item, value));
        return this;
      }

      public void fold() {
        chain.forEach(item -> item.func.accept(item.value));
      }

    }

    Composition c = new Composition();
    c.chain(printer, "Z1")
        .chain(printer, "Z2")
        .chain(printer, "Z3");

    c.fold();

  }

}
