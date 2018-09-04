package months;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Months implements Iterable<String> {
    private final String[] months = {"Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final List<String> m = Arrays.asList(months);
    @Override
    public Iterator<String> iterator() {
        return m.iterator();
    }
}
