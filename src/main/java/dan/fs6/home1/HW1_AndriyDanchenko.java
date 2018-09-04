package dan.fs6.home1;

import java.util.*;

public class HW1_AndriyDanchenko {

    public static void main(String[] args) {

        System.out.println("Input a positive int for printX (int size).");
        System.out.print("Size: ");

        Scanner in = new Scanner (System.in);
        int size = in.nextInt();


        printX(size);
        printXNested(size);
        printXOptimized(size);

        in.close();

    }

    private static void printXOptimized(int size) {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(
                                i == 0 || j == 0 || i == size - 1 || j == size - 1 ||
                                j == i ||
                                j + i == size - 1
                                ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void printX (int size){
        System.out.println("printX:");
        for (int i = 0; i < size * size; i++){
            if (i < size || i % size == 0 || i % size == i / size ||
                    (i + 1) % size == 0 || i % (size - 1) == 0 || i > size * (size - 1)){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            if ((i + 1) % size == 0){
                System.out.println();
            }
        }
        System.out.println("Done.\n");
    }

    public static void printXNested (int size){

        System.out.println("printXNested:");


        for (int i = 0; i < size; i++){

            for (int j = 0; j < size; j++){

                if (j + i == size - 1 || i == 0 || j == 0 || i == size - 1 ||
                        j == size - 1 || j == i ){

                    System.out.print("*");

                }else {

                    System.out.print(" ");

                }
            }

            System.out.println();
        }

        System.out.println("Done.\n");

    }

}