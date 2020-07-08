package parsers;

import java.util.stream.Stream;

public class TrackingParser  {

  public static void main(String[] args) {
    Stream.of(
        "https://www.yegor256.com/2017/09/12/evil-object-name-suffix-client.html",
        "https://stackoverflow.com/questions/23932061/convert-iterable-to-stream-using-java-8-jdk"
    ).map(ProcessText::process)
    .forEach(itm -> itm.forEach((w, c) -> System.out.printf("c:%3d w:%s\n", c, w)));
  }
}
