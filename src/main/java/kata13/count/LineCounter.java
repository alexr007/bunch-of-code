package kata13.count;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.stream.Stream;

public class LineCounter {
  public final File file;

  public LineCounter(File file) {
    this.file = file;
  }

  @SneakyThrows
  public long simple() {
    try (Stream<String> stream = Files.lines(file.toPath())) {
      return stream.count();
    }
  }
}
