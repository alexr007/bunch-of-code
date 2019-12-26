package functions;

import java.util.function.Function;

/**
 * functions:
 * consuming functions by methods
 */
public class Func3_Consuming {

  static final Function<Integer, Integer> f_ident = x -> x;
  static final Function<Integer, Integer> f_square = x -> x * x;
  static final Function<Integer, Integer> f_cube = x -> x * x * x;

  static int do_op(int x, Function<Integer, Integer> op) {
    return op.apply(x);
  }

  public static void main(String[] args) {

    int applied1 = do_op(5, f_ident);
    int applied2 = do_op(5, f_square);
    int applied3 = do_op(5, f_cube);

    System.out.println(applied1); // 5
    System.out.println(applied2); // 25
    System.out.println(applied3); // 125
  }

}
