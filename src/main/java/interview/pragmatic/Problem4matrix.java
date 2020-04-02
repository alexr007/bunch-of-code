package interview.pragmatic;

import java.util.StringJoiner;

public class Problem4matrix {

  static String traverse(int R, int C, int[][] m) {
    StringJoiner sj = new StringJoiner(" ");
    int r = 0;
    int c = 0;
    int next = 1;
    while (true) {
      int v = m[r][c];
      sj.add(String.valueOf(v));
//      System.out.printf("r=%2d, c=%2d, V:%2d D:%d --- ",r,c,v,next);
      if (r == R-1 && c == C-1) break;
      switch (next) {
        case 1:
               if (r == 0 && c == 0) {      c++; next = 2; } // first move
          else if (r == 0)           { r++; c--; next = 2; } // first row
          else if (r==R-1)           { r--; c++; next = 4; } // last row
          break;
        case 2:
               if (r == R-1       ) {      c++; next = 1; } // last row
          else if (         c == 0) { r++;      next = 4; } // first column
          else                      { r++; c--;           } // keep moving
          break;
        case 4:
               if (       c == C-1) { r++;      next = 2; } // last column
          else if (r == 0         ) {      c++; next = 1; } // first row
          else                      { r--; c++;           } // keep moving
          break;
      }
//      System.out.printf("> r=%2d, c=%2d, ND:%d\n",r,c,next);
    }
    return sj.toString();
  }

  public static void main(String[] args) {
    int[][]a = {
        {1,  2, 3},
        {5,  6, 7},
        {9, 10,11},
        {13,14,15},
        {17,18,19},
        {21,22,23},
        {25,26,27},
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
    traverse(a.length, a[0].length, a);
  }
}
