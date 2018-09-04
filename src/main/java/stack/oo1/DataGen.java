package stack.oo1;

import java.util.HashMap;
import java.util.Map;

public class DataGen {
    public Map<String,Integer> data() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Developer", 30000);
        map.put("Manager", 50000);
        return map;
    }
}
