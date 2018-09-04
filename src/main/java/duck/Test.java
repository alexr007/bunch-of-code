package duck;

public class Test {

    public static void method1(Duck d) {
        d.walk();
        d.think();
    }

    public static void method2(Walkable w) {
        w.walk();
    }

    public static void main(String[] args) {
        method1(new Duck());
        method2(new Duck());
        method2(new Goose());

        Duck d = new Duck();
        d.walk();
    }
}
