package olg;

public class M235 {
    public static double getMantissa(float x) {
        int exponent = Math.getExponent(x);
        return x / Math.pow(2, exponent);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2147483647+1);



/*        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }*/
/*
        for (double x = 0.0; x <= 10.0; x += 0.1d) {
            System.err.println(x);
        }
*/
/*
        float f = 0.235f;
        int exp = Math.getExponent(f);
        double mantissa = getMantissa(f);
        System.out.println(exp);
        System.out.println(mantissa);
*/
    }

}
