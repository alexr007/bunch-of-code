package nov30samples;

import java.util.Arrays;
import java.util.List;

public class Thinkable1 implements Thinkable {
  private int value;

  int calc(int x, int y) {
    return x + y;
  }

  @Override
  public void think1() {
    value = 1;
  }

  @Override
  public void think2() {
    value = 2;
  }

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5);
    integers.stream()
        .map(val -> val * 2)
        .forEach(val -> System.out.println(val+" "));
  }

}
