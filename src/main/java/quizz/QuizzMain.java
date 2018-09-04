package quizz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QuizzMain {
    public static void main1(String[] args) {
        int[] a = new int[1];
        int i = 2;
        a[--i] = 1/--i;
    }

    public static void main2(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("thread finished"));
        synchronized (thread) {
            thread.start();
            thread.wait();
        }
        System.out.println("done");
    }

    public static void main3(String[] args) {
        Set<Object> t = new TreeSet<>();
        t.add(1);
        t.add(1L);
        t.add(1.0);
        System.out.println(t.size());
    }

    public static void main4(String[] args) {
        List al = new ArrayList<Long>();
        al.add(1L);
        al.add(1.0);
        al.add(new Object());
        al.add("I am Lonng");
    }

    public static void main(String[] args) {
        System.out.println(Values.A);
    }
}
