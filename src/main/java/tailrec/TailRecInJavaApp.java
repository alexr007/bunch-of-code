package tailrec;

import io.vavr.Tuple2;
import io.vavr.control.Either;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class TailRecInJavaApp {
  /**
   * formally tail recursive function is function which
   * call itself as the last statement
   *
   * so, generally, for 2 param function
   * f: (A, B) => C
   * we need to have implemented two things
   * f': (A, B) => C
   * f": (A, B) => Tuple2[A, B]
   * or
   * f: (A, B) => Either[C, Tuple2[A, B]]
   *
   * this function can be represented as:
   * BiFunction(A,B) => Either[C, Tuple2[A,B]]
   *
   *
   */
  public interface TR2F<A, B, C> extends BiFunction<A, B, Either<C, Tuple2<A,B>>> {
    default Either<C, Tuple2<A, B>> finishWith(C result) {
      return Either.left(result);
    }

    default Either<C, Tuple2<A, B>> continueWith(A a, B b) {
      return Either.right(new Tuple2<>(a, b));
    }

    default C run(A a, B b) {
      while (true) {
        Either<C, Tuple2<A, B>> cOrAb = apply(a, b);
        if (cOrAb.isLeft()) return cOrAb.getLeft();
        Tuple2<A, B> ab = cOrAb.get();
        a = ab._1;
        b = ab._2;
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
    TR2F<Integer, Integer, Integer> sum = new TR2F<Integer, Integer, Integer>() {

      @Override
      public Either<Integer, Tuple2<Integer, Integer>> apply(Integer idx, Integer res) {
        // terminate condition
        if (idx == data.size()) return finishWith(res);
        // tail recursion
        return continueWith(idx+1, res + data.get(idx));
      }
    };

    System.out.println(sum.run(0, 0));
  }
}
