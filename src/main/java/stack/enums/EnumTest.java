package stack.enums;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
        Days mo = Days.Monday;

        System.out.println(mo);
        System.out.println(mo.sname());
        System.out.println(Arrays.asList(Days.values()));
    }
}
