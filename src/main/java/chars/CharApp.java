package chars;

public class CharApp {
  public static void main(String[] args) {
    for (int i = 0; i < 'Z' - 'A'; i++) {
      int z = 'A' + 1; // ok
      char x = (char)('Z' + i);
      char k = 'Z';
    }
  }
}
