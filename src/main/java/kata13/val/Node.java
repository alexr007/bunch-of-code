package kata13.val;

import java.io.File;
import java.util.Collections;
import java.util.Set;

public abstract class Node {
  public final File file;
  public final int level;
  public final long count;
  public final Set<Node> children;

  protected Node(File file, int level, long count, Set<Node> children) {
    this.file = file;
    this.level = level;
    this.count = count;
    this.children = children;
  }

  public static Node File(File file, int level, long count) {
    return new Node(file, level, count, Collections.emptySet()) {};
  }

  public static Node Folder(File file, int level, long count, Set<Node> children) {
    return new Node(file, level, count, children) {};
  }

  public static Node Other(File file, int level) {
    return new Node(file, level, 0, Collections.emptySet()) {};
  }
}

