package join;

import org.cactoos.text.JoinedText;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Joined {

    public String joinApproarch1 (Set<String> set) {
        return set.
            stream()
            .collect(Collectors.joining(" "));
    }

    public String joinApproarch2 (Set<String> set) throws IOException {
        return new JoinedText(" ", set).asString();
    }
}
