package so200219;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ideas {
  private static void before(BigDecimal argument) {
    System.out.println("BEFORE: Argument is " + argument);
  }

  private static String addTax(BigDecimal amount) {
    System.out.println("Adding heavy taxes to our poor citizen...");
    return "$" + amount.multiply(new BigDecimal("1.22"));
  }

  public static void main(String[] args) {
    System.out.println("----------------------------------");
    System.out.println("Starting BEFORE combinator demo...");
    System.out.println("----------------------------------");

    Function<BigDecimal, String> addTax = Ideas::addTax;
    Consumer<BigDecimal> before = Ideas::before;
    Function<BigDecimal, String> addTaxDecorated = Before.decorate(before, addTax);

    BigDecimal argument = new BigDecimal("100");
    String result = addTaxDecorated.apply(argument);

    System.out.println("Done - Result is " + result);
    System.out.println();
  }
}
