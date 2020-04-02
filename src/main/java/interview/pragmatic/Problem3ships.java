package interview.pragmatic;

import java.util.Arrays;

public class Problem3ships {

  static void ships(int n, int[] w) {
    int sum = Arrays.stream(w).sum();
    int avg = sum / n;
    int r = sum % n !=0 ? -1 : Arrays.stream(w).map(x -> avg-x).filter(x -> x>0).sum();
    System.out.println(r);
  }

  public static void main(String[] args) {
    int[] a = {1,1,1,1,6};
    ships(a.length, a);
  }
}
