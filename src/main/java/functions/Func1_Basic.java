package functions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * functions:
 * declare and usage
 */
public class Func1_Basic {

  static final Function<Integer, Integer> f_square = x -> x * x;
  static final Function<Integer, Integer> f_inc = x -> x + 1;
  static final BiFunction<Integer, Integer, Integer> f_add = (x, y) -> x + y;

  public static void main(String[] args) {
    int applied1 = f_square.apply(3); // 9
    int applied2 = f_inc.apply(5);    // 6
    int applied3 = f_add.apply(1, 2);   // 3
    System.out.println(applied1);
    System.out.println(applied2);
    System.out.println(applied3);
  }

}
