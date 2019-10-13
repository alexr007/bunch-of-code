package interview.trading;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chm {
  public static void main(String[] args) {
    Map<Integer, List<Integer>> collect = IntStream.range(0, 100).boxed()
        .collect(
            Collectors.groupingBy(k -> k % 3));
    collect.forEach((k, v) -> System.out.printf("K:%s, V:%s\n", k, v));

    AtomicInteger ai = new AtomicInteger();

    ai.getAndIncrement();
    ai.incrementAndGet();

    ai.getAndDecrement();
    ai.decrementAndGet();

    ai.get();
    ai.set(5);

    int i = ai.accumulateAndGet(5, (left, right) -> left + right);
    int j = ai.getAndAccumulate(6, (a, b) -> a + b);
    int i1 = ai.addAndGet(5);
    int i2 = ai.getAndAdd(5);
    int i3 = ai.getAndSet(6);
    int i4 = ai.getAndUpdate(v -> v * 2);

    boolean b = ai.compareAndSet(5, 6);
    ai.lazySet(33);


  }
}
