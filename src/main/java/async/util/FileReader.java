package async.util;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class FileReader {

    @SneakyThrows
    String readFile(String path) {
        return Files
          .lines(Paths.get(path))
          .map(String::toUpperCase)
          .collect(Collectors.toList()).toString();
    }
}
