package so180717;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SomeListTest {
    public static void main(String[] args) {
        ArrayList<SomeClass> al = new ArrayList<>();
        al.add(new SomeClass(1,"apple"));
        al.add(new SomeClass(1,"banana"));
        al.add(new SomeClass(1,"orange"));
        al.add(new SomeClass(2,"papaya"));
        al.add(new SomeClass(2,"peaches"));
        al.add(new SomeClass(3,"melons"));
        Map<Integer, Set<String>> collect = al.stream()
                .collect(
                        Collectors.groupingBy(
                                SomeClass::getRid, Collectors.mapping(SomeClass::getName, Collectors.toSet())));
        System.out.println(collect);
    }

}
