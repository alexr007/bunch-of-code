package interview.sinus;

import java.util.Scanner;

public class Cosinus {
    public static long factorial(long n) {
        return n==1 ? 1 : n * factorial(n-1);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        System.out.print("Enter the X:");
        final double x = in.nextDouble();

        System.out.print("Enter the epsilon:");
        final double epsilon = in.nextDouble();

        double expected = Math.cos(x);
        System.out.printf("Expected:    %.16f\n", expected);

        double calculated = 1;
        double elem;

        for (long n=1; ; n++) {
            elem = Math.pow(-1, n) * Math.pow(x, n*2) / factorial(n*2);
            calculated += elem;
            System.out.printf("iteration:%2d, elem:%19.16f, result:%19.16f\n", n, elem, calculated);
            if (Math.abs(elem) < epsilon) break;
        }

        System.out.println("cos(x)=");
        System.out.printf("Expected:    %19.16f\n", expected);
        System.out.printf("Calculated:  %19.16f\n", calculated);
        System.out.printf("Comp mistake:%19.16f\n", Math.abs(calculated - expected));
        System.out.printf("Epsilon:     %19.16f\n", epsilon);
    }

}
