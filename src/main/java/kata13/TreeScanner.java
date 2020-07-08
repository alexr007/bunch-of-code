package kata13;

import kata13.count.LineCounter;
import kata13.val.Node;
import kata13.val.RowInfo;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeScanner {
  public final File root;

  public TreeScanner(File root) {
    this.root = root;
  }

  static String last(File f) {
    return last(f.toPath());
  }

  static String last(Path path) {
    String[] chunks = path.toString().split("/");
    return chunks[chunks.length-1];
  }

  public boolean filterExt(File fl) {
    return fl.isFile() && fl.toString().toLowerCase().endsWith(".java");
  }

  public Node scan(File file) {
    return scan(file, 0);
  }

  public Node scan(File file, int level) {
    if (file.isFile()) return filterExt(file) ? Node.File(file, level, new LineCounter(file).simple()) : Node.Other(file, level);
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      Set<Node> nodes = files == null ? Collections.emptySet() : Arrays.stream(files)
          .map(f -> scan(f, level + 1))
          .collect(Collectors.toSet());
      long count = nodes.stream()
          .map(n -> n.count)
          .reduce(Long::sum)
          .orElse(0L);
      return Node.Folder(file, level, count, nodes);
    }
    return Node.Other(file, level);
  }

  public List<RowInfo> represent(Node node) {
    return represent(node, new ArrayList<>());
  }

  public List<RowInfo> represent(Node node, List<RowInfo> items) {
    items.add(new RowInfo(node.level, last(node.file), node.count));
    node.children.stream()
        .filter(n -> n.count > 0)
        .forEach(n -> represent(n, items));
    return items;
  }

  public Stream<String> countAll() {
    return represent(scan(root)).stream()
        .map(RowInfo::toString);
  }

}
