package oop2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Sample1 {


    public static void main3(String[] args) {
        Person p1 = new Person();
        p1.name="Petro";
        p1.age=20;
        p1.year=1990;
        p1.position="Student";

        Person p2 = new Person();
        p2.name="Victor";
        p2.age=33;
        p2.year=1970;
        p2.position="Dean";

        calculate(p1);
        calculate(p2);
    }

    public static void main4(String[] args) {
/*
        Student p1 = new Student();
        p1.name="Petro";
        p1.age=20;
        p1.year=1990;
        p1.position="Student";

        Teacher p2 = new Teacher();
        p2.name="Victor";
        p2.age=33;
        p2.year=1970;
        p2.position="Dean";
*/
    }

    public static void main5(String[] args) {
        int i = 1;
        Integer j = new Integer(1);
        double d = 2.0d;

        Double d1 = new Double(1.0d);
        Double d2 = new Double(1.0d);

        System.out.println(d1==d2);
        System.out.println(d1.equals(d2));
    }

    public static void main(String[] args) {
        Student s1 = new Student(1990, "Alex");
        Student s2 = new Student(1991,"Petr");
        Student s3 = Student.build(1992,"Andy");
        Teacher t1 = new Teacher(1970, "Victor");
        Teacher t2 = new Teacher(1972, "Masha");
        Cat cat = new Cat();
        ArrayList<Doable> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(t1);
        l.add(t2);
        l.add(cat);
        l.forEach(d->d.doIt());
        l.forEach(Doable::doIt);
        l.forEach(new ConsumerDoable());
        l.forEach(new Consumer<Doable>() {
            @Override
            public void accept(Doable d) {
                d.doIt();
            }
        });
/*
        @BAD DESIGN !!!
        l.forEach(new Consumer<Doable>() {
            @Override
            public void accept(Doable doable) {
                doable.doIt();
                if(doable instanceof Cat) {
                    ((Cat) doable).meo();
                }
            }
        });
*/
/*
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.value());
        t1.printMe();
        t2.printMe();
        Cat cat = new Cat();
        calculate3(s1);
        calculate3(cat);
*/
    }

    Doable build1() {
        return new Student(10, "Vanya");
    }

    Doable build2() {
        return new Cat();
    }

    private static void calculate3(Doable s1) {
        //s1.printMe();
        s1.doIt();
    }

    private static int calculate2(int age, String name) {
        return 0;
    }

    private static int calculate(Person sc) {
        int i=sc.age;
        int y=sc.year;
        String s=sc.name;
        return 0;
    }

    private static int calculate(int age, String s, String name) {
        return 0;
    }
}
