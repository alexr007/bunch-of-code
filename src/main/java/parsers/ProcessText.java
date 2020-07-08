package parsers;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessText {
  @SneakyThrows
  public static Map<String, Long> process(String origin) {
    return Stream.of(Jsoup.connect(origin).get().text().split("\\W+"))
        .filter(s -> s.length() > 2)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
        ));
  }
}
