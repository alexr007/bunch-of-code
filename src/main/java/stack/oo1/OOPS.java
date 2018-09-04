package stack.oo1;

import java.util.Map;

public class OOPS {
    private final Map<String, Integer> origin;

    public OOPS(DataGen data) {
        this(data.data());
    }

    public OOPS(Map<String, Integer> origin) {
        this.origin = origin;
    }

    public int salary(String name) throws Exception {
        return origin.keySet().stream()
            .filter(en->en.equals(name))
            .map(origin::get)
            .findFirst()
            .orElseThrow(()->new Exception("not found"));
    }

}
