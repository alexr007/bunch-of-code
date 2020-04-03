package interview.pragmatic;

import java.util.StringJoiner;

public class Problem4matrix {

  static String traverse(int R, int C, int[][] m) {
    StringJoiner sj = new StringJoiner(" ");
    int r = 0, c = 0, next = 0;
    while (true) {
      sj.add(String.valueOf(m[r][c]));
      if (r == R-1 && c == C-1) break;
      switch (next) {
        case 0: c++; next++; break;
        case 1:
               if (r == R-1) {      c++; next++; } // last row
          else if (c == 0  ) { r++;      next++; } // first column
          else               { r++; c--;         }
          break;
        case 2:
               if (c == C-1) { r++;      next--; } // last column
          else if (r == 0  ) {      c++; next--; } // first row
          else               { r--; c++;         }
          break;
      }
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    int[][]a = {
        {1,  2, 3},
        {5,  6, 7},
        {9, 10,11},
        {13,14,15},
//        {17,18,19},
//        {21,22,23},
//        {25,26,27},
//        {1,  2, 3, 4, },
//        {5,  6, 7, 8, },
//        {9, 10,11, 12,},
//        {13,14,15, 16,},
//        {17,18,19, 20,},
//        {21,22,23, 24,},
//        {25,26,27, 28,},
//        {1,  2,},
//        {5,  6,},
//        {9, 10,},
//        {13,14,},
//        {17,18,},
//        {21,22,},
//        {25,26,},
//        {1,  2, 3, 4,  100},
//        {5,  6, 7, 8,  101},
//        {9, 10,11, 12, 102},
//        {13,14,15, 16, 103},
//        {17,18,19, 20, 104},
//        {21,22,23, 24, 105},
//        {25,26,27, 28, 106},
    };
    System.out.println(traverse(a.length, a[0].length, a));
  }
}
