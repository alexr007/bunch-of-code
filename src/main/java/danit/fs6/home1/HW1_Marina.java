package danit.fs6.home1;

public class HW1_Marina {
    public static void main(String[] args) {
        int size=9;
        v1(size);
        System.out.println();
        v2(size);
    }

    private static void v1(int size) {
        for(int i=0; i < size; i++) {
            for(int k=0; k < size; k++) {
                if (k == 0 || k == size - 1 || k == (i)+1 || k == (size-1-i)|| i == 0 || i == size - 1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void v2(int size) {
        for(int i=0; i < size; i++) {
            for(int k=0; k < size; k++) {
                if (k == 0 || k == size - 1 || i == 0 || i == size - 1
                        || k == (i)+1
                        || k == (size-1-i)
                        ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
