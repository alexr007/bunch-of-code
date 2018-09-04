package fs2;

import java.util.HashSet;

public class Set1 {
    public static void main(String[] args) {
        HashSet<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove((short)(i-1));
        }
        System.out.println(s.size());
    }
}
