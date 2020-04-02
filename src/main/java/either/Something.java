package either;

import io.vavr.control.Either;

public class Something {
  public static Either<Exception, Integer> process(String line) {
    try {
      return Either.right(Integer.parseInt(line));
    } catch (NumberFormatException ex) {
      return Either.left(ex);
    }
  }

  public static void main(String[] args) {
    String folded = process("1a23")
        .map(x -> x * 2)
        .fold(
            ex -> "Wrong",
            x -> String.format("Result: %d\n", x)
        );
    System.out.println(folded);
  }
}
