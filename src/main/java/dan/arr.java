package dan;

import java.util.Scanner;

public class arr {
    final static int DIMENSION=10;

    private static boolean shouldPaint(int row, int col) {
        return row==1 || col==1 || row==DIMENSION || col==DIMENSION || col==row || row+col==1+DIMENSION;
    }

    public static void main2(String[] args) {
        for (int row = 1; row <= DIMENSION; row++) {
            for (int col = 1; col <= DIMENSION; col++) {
                if (shouldPaint(row, col)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        for (int i=1; i<= DIMENSION*DIMENSION; i++) {
            int row = i / DIMENSION + 1;
            int col = i % DIMENSION == 0 ? DIMENSION : i % DIMENSION;
            System.out.print(shouldPaint(row,col) ? "*" : " ");
            if (col == DIMENSION) {
                System.out.println();
            }
        }
    }

    public static void main4(String[] args) {
        for (int j=DIMENSION*DIMENSION; j>0 ; j--) {
            int i=DIMENSION*DIMENSION-j+1;

            int row = i / DIMENSION + 1;
            int col = i % DIMENSION == 0 ? DIMENSION : i % DIMENSION;
            System.out.print(shouldPaint(row,col) ? "*" : " ");
            if (col == DIMENSION) {
                System.out.println();
            }
        }
    }

    public static void main5(String[] args) {
        int i=0;
        while (true) {
            System.out.println(i);
            i++;
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("after");
            if (i>10) break;
        }
    }

    public static void main6(String[] args) {
        int row = 1;

        while (true) {
            for (int col = 1; col <= DIMENSION; col++) {
                if (shouldPaint(row, col)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            row++;
            if (row > DIMENSION) break;
        }
    }

    public static void main7(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = N - i;
        }
        for(int i = 0; i<N; i++){
            System.out.printf("%d ", numbers[i]);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Dear friend, please enter the dimension:");
        int N = in.nextInt();
        int[] numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = N - i;
        }
        System.out.println("Normal");
        for(int i = 0; i<N; i++){
            System.out.printf("%d ", numbers[i]);
        }
        for (int i = 0; i < numbers.length/2 ; i++) {
            int tmp = numbers[i];
            numbers [i] = numbers [N-1-i];
            numbers[N-1-i] = tmp;
        }
        System.out.println("\nReverted");
        for(int i = 0; i<N; i++){
            System.out.printf("%d ", numbers[i]);
        }
    }
}
