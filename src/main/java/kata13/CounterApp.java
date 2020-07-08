package kata13;

import java.io.File;

public class CounterApp {

  public static void exit(String message) {
    System.err.println(message);
    System.exit(-1);
  }

  private static File validate(String[] args) {
    if (args.length == 0) exit("file or folder name is expected as a parameter to run the app");
    File path = new File(args[0]);
    if (!path.exists()) exit("valid file or folder name is expected as a parameter to run the app");
    return path;
  }

  public static void main(String[] args) {
    new TreeScanner(validate(args))
        .process()
        .forEach(System.out::println);
  }
}
