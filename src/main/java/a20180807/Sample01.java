package a20180807;

public class Sample01 {
    public static String wrap(String elem, String tag) {
        return "<"+tag+">"+elem+"</"+tag+">";
    }

    public static void print(int from, int to) {
        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) {
                System.out.print(wrap(Integer.toString(i),"h1")+" ");
            } else {
                System.out.print(wrap(Integer.toString(i),"h2")+" ");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(1,10);
        print(10,20);
        print(11,22);
    }
}
