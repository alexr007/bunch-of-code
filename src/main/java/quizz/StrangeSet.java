package quizz;

import java.util.HashSet;

public class StrangeSet {
    public static void main(String[] args) {
        HashSet<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 1);
        }
        System.out.println(s.size());
    }
}
