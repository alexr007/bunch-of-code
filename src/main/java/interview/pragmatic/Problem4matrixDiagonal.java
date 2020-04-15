package interview.pragmatic;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4matrixDiagonal {

  static String traverse(int R, int C, int[][] m) {
    StringJoiner sj = new StringJoiner(" ");
    int r = 0, c = 0, next = 0;
    do {
      sj.add(String.valueOf(m[r][c]));
      switch (next) {
        case 0: c++; next=1; break;
        case 1:
               if (r == R-1) {      c++; next=2; } // last row
          else if (c == 0  ) { r++;      next=2; } // first column
          else               { r++; c--;         }
          break;
        case 2:
               if (c == C-1) { r++;      next=1; } // last column
          else if (r == 0  ) {      c++; next=1; } // first row
          else               { r--; c++;         }
      }
    } while (r<R && c<C);
    return sj.toString();
  }

  static class Track {
    int r = 0;
    int c = 0;
    int next = 0;
  }
  static String traverse2(int R, int C, int[][] m) {
    Track t = new Track();
    return IntStream.range(0, R * C).map(n -> {
      int val = m[t.r][t.c];
      switch (t.next) {
        case 0: t.c++; t.next=1; break;
        case 1:
          if      (t.r == R-1) {        t.c++; t.next=2; } // last row
          else if (t.c == 0  ) { t.r++;        t.next=2; } // first column
          else                 { t.r++; t.c--;           }
          break;
        case 2:
          if      (t.c == C-1) { t.r++;        t.next=1; } // last column
          else if (t.r == 0  ) {        t.c++; t.next=1; } // first row
          else                 { t.r--; t.c++;           }
      }
      return val;
    })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static String traverse3(int R, int C, int[][] m) {
    StringJoiner sj=new StringJoiner(" ");

    int row=0;
    int sumofIndexes=0;
    int numberofCombinations=1;
    int counter=0;

    for (int i = 0; i < R*C ; i++) {
      if (row<R && sumofIndexes-row<C)
        sj.add(String.valueOf(m[row][sumofIndexes-row]));

      if (row>=R || sumofIndexes-row>=C)
        i--;
      counter++;
      row = (sumofIndexes&1)==0 ? row-1 : row+1;
      if(counter == numberofCombinations){
        sumofIndexes++;
        numberofCombinations = sumofIndexes + 1;
        counter = 0;
        row = (sumofIndexes&1)==0 ? sumofIndexes : 0 ;
      }
    }
    return sj.toString();
  }

  public static void main(String[] args) {
//        {1,  2, 3},
//        {5,  6, 7},
//        {9, 10,11},
//        {13,14,15},
//        {17,18,19},
//        {21,22,23},
//        {25,26,27},
    int[][]a = {
        {  1,  2,  3,  4, },
        {  5,  6,  7,  8, },
        {  9, 10, 11, 12, },
        { 13, 14, 15, 16, },
        { 17, 18, 19, 20, },
        { 21, 22, 23, 24, },
        { 25, 26, 27, 28, },
    };
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
//    };
    System.out.println("1 2 5 9 6 3 4 7 10 13 17 14 11 8 12 15 18 21 25 22 19 16 20 23 26 27 24 28");
    System.out.println(traverse(a.length, a[0].length, a));
    System.out.println(traverse2(a.length, a[0].length, a));
    System.out.println(traverse3(a.length, a[0].length, a));
  }
}
