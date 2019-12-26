package functions;

import java.util.function.Function;

/**
 * functions:
 * returning functions from methods
 */
public class Func2_Returning {

  static final Function<Integer, Integer> f_ident = x -> x;
  static final Function<Integer, Integer> f_square = x -> x * x;
  static final Function<Integer, Integer> f_cube = x -> x * x * x;

  static Function<Integer, Integer> get_f(int id) {
    switch (id) {
      case 1: return f_ident;
      case 2: return f_square;
      case 3: return f_cube;
      default: throw new IllegalArgumentException("this case isn't covered");
    }
  }

  public static void main(String[] args) {
    Function<Integer, Integer> f1 = get_f(1); // f1 - identity
    Function<Integer, Integer> f2 = get_f(2); // f2 - square
    Function<Integer, Integer> f3 = get_f(3); // f3 - cube

    System.out.println(f1.apply(11)); // 11
    System.out.println(f2.apply(11)); // 121
    System.out.println(f3.apply(5)); // 125
  }

}
