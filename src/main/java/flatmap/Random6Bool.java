package flatmap;

public class Random6Bool {
  public static void main(String[] args) {
    boolean[] a = new boolean[1000];
    for (int i = 0; i < a.length / 6; i++) {
      int pos = (int)(Math.random()*a.length);
      a[pos] = true;
    }
  }
}
