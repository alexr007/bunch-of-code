package danit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompTest {
    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();
        l.add(new Person(21, 10000, "Masha"));
        l.add(new Person(25, 12000, "Sergey"));
        l.add(new Person(30, 25000, "Roma"));
        l.add(new Person(23, 20000, "Alina"));
        l.add(new Person(55, 55000, "Anne"));

        System.out.println("Unsorted:");
        l.forEach(person -> person.printMe());

        System.out.println("Sorted by Comparable(age):");
        Collections.sort(l);
        l.forEach(Person::printMe);

        Comparator<Person> c1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.rate()-o2.rate();
            }
        };

        Comparator<Person> c2 = (Person o1, Person o2) -> {
            return o1.rate()-o2.rate();
        };

        Comparator<Person> c3 = (o1, o2) -> {
            return o1.rate()-o2.rate();
        };

        Comparator<Person> c4 = (o1, o2) -> o1.rate() - o2.rate();



        System.out.println("Sorted by Comparator(name):");
        Collections.sort(l, new CompByName());
        Collections.sort(l, c1);
        Collections.sort(l, c4);
        Collections.sort(l, (o1, o2) -> o1.rate() - o2.rate());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(rate):");
        Collections.sort(l, new CompByRate());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(age):");
        Collections.sort(l, new CompByAge());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator(rate(lambda)):");
        Collections.sort(l, (o1, o2) -> o1.rate()-o2.rate());
        l.forEach(Person::printMe);

        System.out.println("Sorted by Comparator.comparingInt(rate):");
        Collections.sort(l, Comparator.comparingInt(Person::rate));
        l.forEach(Person::printMe);

        System.out.println("Sorted by Compator.comparing(name):");
        Collections.sort(l, Comparator.comparing(o -> o.name().toString()));
        l.forEach(Person::printMe);
    }
}
