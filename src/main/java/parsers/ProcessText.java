package parsers;

import org.cactoos.text.SplitText;
import org.cactoos.text.TextOf;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ProcessText {
  public static Map<String, Long> process(String origin) {
    try {
      Stream<String> text = StreamSupport.stream(
          new SplitText(
              Jsoup.parse(new TextOf(new URL(origin)).asString()).text(),
              new TextOf("\\W+")
          ).spliterator(), false)
          .map(Object::toString);
      return text.filter(s -> s.length() > 2)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
          .entrySet().stream()
          .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
          .collect(Collectors.toMap(
              Map.Entry::getKey,
              Map.Entry::getValue,
              (e1, e2) -> e1,
              LinkedHashMap::new
          ));
    } catch (IOException e) {
      throw new IllegalArgumentException("IOEX", e);
    }
  }
}
