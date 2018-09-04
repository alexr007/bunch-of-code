package parsers;

import org.cactoos.Text;
import org.cactoos.text.SplitText;
import org.cactoos.text.TextOf;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ProcessText {
    private final String origin;

    public ProcessText(String s) {
        origin = s;
    }

    public void function () {
        ArrayList<Integer> integers = new ArrayList<>();
        Collections.sort(integers, Comparator.comparingInt(o -> o));
    }


    public void process() {
        try {
            StreamSupport.stream(
                    new SplitText(
                            Jsoup.parse(
                                    new TextOf(
                                            new URL(origin)
                                    ).asString())
                                    .text(),
                            new TextOf("\\W+")
                    ).spliterator(), false)
                    .map(s->s.toString())
                    .filter(s -> s.length() > 2)
                    .collect(
                            Collectors.groupingBy(
                                    Function.identity(), Collectors.counting()
                            )
                    ).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
                ))
                .forEach((word, count) -> System.out.printf("C:%3d, W:%s\n", count, word));
        } catch (IOException e) {
            System.err.println("IOException");
        }
    }
}
