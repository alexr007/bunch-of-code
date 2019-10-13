package a20180807;

import java.util.Arrays;
import java.util.List;

public class A1 {
  class Data implements Comparable<Integer> {

    @Override
    public int compareTo(Integer o) {
      return 0;
    }
  }

  public static void main(String[] args) {
    Integer[] d = {1,2};
    List<Integer> ints = Arrays.asList(d);
    Integer[] objects = (Integer[]) ints.toArray();

  }
}
