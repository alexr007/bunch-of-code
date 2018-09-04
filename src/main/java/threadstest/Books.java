package threadstest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Books {
    final Map<Integer, String> map = new ConcurrentHashMap<>();

    int add(String title) {
        final Integer next = this.map.size() + 1;
        this.map.put(next, title);
        return next;
    }

    String title(int id) {
        return this.map.get(id);
    }
}
