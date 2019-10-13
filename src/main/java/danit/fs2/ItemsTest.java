package danit.fs2;

import java.util.Iterator;

public class ItemsTest {
    public static void main(String[] args) {
        for (int i : new Items()) {
            System.out.println(i);
        }

        Iterator<Integer> it = new Items().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
