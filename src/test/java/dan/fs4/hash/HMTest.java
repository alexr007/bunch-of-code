package dan.fs4.hash;

import org.junit.Test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HMTest {
    public static class Empl{

        public int id;
        public int salary;

        public Empl(int n, int s){
            this.id = n;
            this.salary = s;
        }
        public int getId() {
            return id;
        }
        public  int getSalary() {
            return salary;
        }
    }

    public void testCollectionsSort() {
/*
        ArrayList<Empl> a = new ArrayList<>();
        Collections.sort(a,Comparator.comparingInt(item->item.getSalary()));
*/
    }

    @Test
    public void testDictionaryOnConsole() {
        Stream.of("cc a b c aa bb cc b cc bb bb".split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(item -> System.out.printf("%s: %d\n", item.getKey(), item.getValue()));
    }

    @Test
    public void testInteger() {
        int[] a = { 5,4,3,2,1};
        Arrays.stream(a)
                .forEach(System.out::println);
    }

    @Test
    public void testInteger2() {
        IntStream.rangeClosed(1,100)
                .filter(value -> value%2==0)
                .filter(value -> value%3==0)
                .mapToObj(Customer::new)
                .filter(Customer::filter)
                .forEach(value -> System.out.println("i="+value));
    }

}