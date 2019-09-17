package smarttest;

import java.util.ArrayList;
import java.util.List;

public class Ham01 {
    public List<String> get3() {
        return new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
        }};
    }
}
