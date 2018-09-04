package stack.generic;

public class genericTest {
    public static void main(String[] args) {
        System.out.println("learning generics");
        // base assignment
        Z1 z1 = new Z1();
        Z2 z2 = new Z2();

        // native cast up, compiler show warning
        Z0 z01 = z1;
        Z0 z02 = z2;

        // type casting with helper function, no warning
        Z0 z011 = z1.cast();
        Z0 z022 = z2.cast();

        Z0 z0 = new Z0();

        /*
        class cast UP
        IMPOSSIBLE CONVERSION !!!
        each 4 lines will throw exception, but compiler seems Okay
         */
        Z1 z12 = (Z1)z0;
        Z2 z13 = (Z2)z0;
        Z1 z11 = z0.cast();
        Z2 z14 = z0.cast();
    }
}
