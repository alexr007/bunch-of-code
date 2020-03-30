package hackerrank.d200330;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemsDay5 {

  public static void xtralongfact(int n) {
    BigDecimal r = new BigDecimal(1);
    for (int i = 1; i <= n; i++) {
      r = r.multiply(new BigDecimal(i));
    }
    System.out.println(r.toString());
  }

  static String encryption(String sx) {
    final String s2 = sx.replace(" ", "");
    int len = s2.length();
    double l = Math.sqrt(len);
    final int l1 = (int) Math.floor(l);
    final int l2 = (int) Math.ceil(l);
    int cols = l2;
    int rows = l1 == l2 ? l2 : l1*l2 < len ? l2 : l1;

    return IntStream.range(0, cols).boxed().flatMap(c ->
        IntStream.range(0, rows).boxed().map(r -> {
          int idx = r*cols+c;
          String ch = idx < len ? String.valueOf(s2.charAt(idx)) : "";
          return r==rows-1 ? ch +" ": ch;
        })).collect(Collectors.joining());
  }

  public static void main_encryption(String[] args) {
//    System.out.println(encryption("have a nice day"));
//    System.out.println(encryption("feed the dog"));
    System.out.println(encryption("chillout"));
  }

  static int[][] convert(String[] grid) {
    int[][] data = new int[grid.length][grid[0].length()];
    IntStream.range(0, grid.length).forEach(y ->
        IntStream.range(0, grid[0].length()).forEach(x ->
            data[y][x] = grid[y].charAt(x) == 'G' ? 0 : 9));
    return data;
  }

  static class PlusAt {
    final int x;
    final int y;
    final int size;

    PlusAt(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
    }
  }

  static boolean freeHorAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      if (data[y][x+i] != 0) return false;
    }
    return true;
  }

  static void occupyHorAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      data[y][x+i] = 1;
    }
  }

  static void releaseHorAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      data[y][x+i] = 0;
    }
  }

  static boolean freeVerAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      if (data[y+i][x] != 0) return false;
    }
    return true;
  }

  static void occupyVerAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      data[y+i][x] = 1;
    }
  }

  static void releaseVerAt(int x, int y, int len, int[][] data) {
    for (int i = 0; i < len; i++) {
      data[y+i][x] = 0;
    }
  }

  static boolean isPossibleAt(int x, int y, int size, int[][] data) {
    return freeHorAt(x+size/2, y, size, data)
        && freeVerAt(x, y+size/2, size, data);
  }

  static void occupyAt(int x, int y, int size, int[][] data) {
    occupyHorAt(x+size/2, y, size, data);
    occupyVerAt(x, y+size/2, size, data);
  }

  static void releaseAt(int x, int y, int size, int[][] data) {
    releaseHorAt(x+size/2, y, size, data);
    releaseVerAt(x, y+size/2, size, data);
  }

  static int twoPluses(String[] grid) {
    int[][] data = convert(grid);
    int width = data[0].length;
    int height = data.length;
    int max_w = (width & 1) == 0 ? width - 1 : width;
    int max_h = (height & 1) == 0 ? height - 1 : height;
    int max_size = Math.min(max_w, max_h);
    IntStream.rangeClosed(1, max_size).filter(x -> (x & 1) != 0).map(x -> max_size+1-x).boxed().flatMap(size1 ->
            IntStream.rangeClosed(1, max_size).filter(x -> (x & 1) != 0).map(x -> max_size+1-x).boxed().map(size2 ->
                ""
                ));
    throw new RuntimeException();
  }

  public static void main(String[] args) {
  }
}
