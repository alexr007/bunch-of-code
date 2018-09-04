package months;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MonthsTest2 {
    public static void main(String[] args) {
        List<String> m = Arrays.asList("Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        m.sort((o1, o2) -> m.indexOf(o2)-m.indexOf(o1));
        m.forEach(System.out::println);
    }
}
