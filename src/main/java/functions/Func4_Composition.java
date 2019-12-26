package functions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * functions:
 * consuming functions by methods
 */
public class Func4_Composition {

  static final Function<Integer, Integer> f_inc = x -> x + 1;
  static final Function<Integer, Integer> f_mult2 = x -> x * 2;

  public static void main(String[] args) {

    Function<Integer, Integer> f1a = f_inc.andThen(f_mult2);
    Function<Integer, Integer> f1b = f_mult2.compose(f_inc);

    Function<Integer, Integer> f2a = f_inc.compose(f_mult2);
    Function<Integer, Integer> f2b = f_mult2.andThen(f_inc);

    int applied1a = f1a.apply(2);
    int applied1b = f1b.apply(2);
    int applied2a = f2a.apply(2);
    int applied2b = f2b.apply(2);

    System.out.println(applied1a); // f_inc, f_milt2 => 6 (2+1) * 2
    System.out.println(applied1b); // f_inc, f_milt2 => 6
    System.out.println(applied2a); // f_mult2, f_inc => 5 (2*2) + 1
    System.out.println(applied2b); // f_mult2, f_inc => 5
  }

}
