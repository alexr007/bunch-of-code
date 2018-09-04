package dan;

import java.util.HashSet;
import java.util.Optional;
import java.util.function.Function;

public class Equals {
    public static void main(String[] args) {
        HashSet<Person> s = new HashSet<>();
/*
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(3);
*/
        s.add(new Person(30,10000, "Alex"));
        s.add(new Person(35,10000, "Dima"));
        s.add(new Person(35,10000, "Dima"));

        s.stream().map(Object::toString).reduce((a, c) -> a + ",\n" + c).ifPresent(System.out::println);
    }
}
