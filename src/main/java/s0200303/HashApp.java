package s0200303;

import java.util.HashMap;

public class HashApp {
  public static void main(String[] args) {
    HashMap<Integer, String> men = new HashMap<Integer, String>() {{
      put(1, "Jim");
      put(2, "Jack");
      put(3, "Joe");
    }};
  }
}
