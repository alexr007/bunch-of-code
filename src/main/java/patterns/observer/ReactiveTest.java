package patterns.observer;

public class ReactiveTest {
    public static void main(String[] args) {
        Producer p = new Producer();
        Subscriber s1 = new Subscriber("S1");
        Subscriber s2 = new Subscriber("S2");
        Subscriber s3 = new Subscriber("S3");

        p.newEvent(); // will be lost
        System.out.println();

        s1.subscribe(p);
        p.newEvent(); // will be received by s1
        System.out.println();

        s2.subscribe(p);
        p.newEvent(); // will be received by s1, s2
        System.out.println();

        s3.subscribe(p);
        p.newEvent(); // will be received by s1, s2, s3
        System.out.println();

        s1.unSubscribe(p);
        p.newEvent(); // will be received by s2, s3
        System.out.println();



    }
}
