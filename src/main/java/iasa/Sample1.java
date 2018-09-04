package iasa;

public class Sample1 {
    public static void main1(String[] args) {

        Class1 c1 = new Class1();
        c1.x=1;
        c1.y=2;
        System.out.print("C1:");
        System.out.println(c1.x + c1.y);


        Class2 c2 = new Class2(1, 2);
        System.out.println(c2.x());
        System.out.println(c2.x);

        System.out.print("C2:");
        System.out.println(c2.sum());


        Class3 c3 = new Class3(3);
        System.out.println(c3.getX());
        c3.add(5);
        System.out.println(c3.getX());

        System.out.println(c3.getXs());
    }

    public static void main2(String[] args) {
        float f1=0.128f;
        float f2=0.256f;
        float f3=f1+f2;
        System.out.println(f3);
    }

    public static void main3(String[] args) {
        Point p = new Point(1, 2);
        System.out.println(p.value());

        Point pointMoved = p.move(5, 10);
        System.out.println(p.value());
        System.out.println(pointMoved.value());

    }

    public static void main4(String[] args) {
        System.out.println(new Price("Apple", 5, "UAH"));
        System.out.println(new Price("Lemon", 15, "EUR"));
        System.out.println(new Price("Pineapple", 25, "USD"));
    }

    public void f1(AbstractInterface a) {
        a.calc();
        a.print();
    }

    public static void main(String[] args) {
        //f1(new Class5());
    }
}
