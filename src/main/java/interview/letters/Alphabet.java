package interview.letters;

import java.util.*;
import java.util.stream.*;

public class Alphabet {

  enum Letters {
    A(
        "   *   ",
        "  * *  ",
        " *   * ",
        "*     *",
        "*******",
        "*     *",
        "*     *"
    ),
    B(
        "*****  ",
        "*     *",
        "*     *",
        "*****  ",
        "*     *",
        "*     *",
        "*****  "
    ),
    C(
        " ***** ",
        "*     *",
        "*      ",
        "*      ",
        "*      ",
        "*     *",
        " ***** "
    ),
    None(
        "*******",
        "*******",
        "*******",
        "*******",
        "*******",
        "*******",
        "*******"
    );

    public final List<String> bitmap;

    Letters(String... bmp) {
      bitmap = Arrays.asList(bmp);
    }
  }

  private final static String SPACE = " ";
  private final static Map<Character, Letters> bitmaps =
      Stream.of(Letters.values())
          .filter(l -> !l.equals(Letters.None))
          .collect(Collectors.toMap(
              letters -> letters.toString().charAt(0),
              letters -> letters
          ));

  public String bitmap(String origin) {
    final List<List<String>> word = origin.chars()
        .mapToObj(c -> bitmaps.getOrDefault((char) c, Letters.None).bitmap)
        .collect(Collectors.toList());

    return IntStream.range(0, word.get(0).size())
        .mapToObj(idx -> word.stream().map(line -> line.get(idx)).collect(Collectors.joining(SPACE)))
        .collect(Collectors.joining("\n"));
  }

  public void print(String word) {
    System.out.println(bitmap(word));
  }

  public static void main(String[] args) {
    final Alphabet a = new Alphabet();
    a.print(" ABCBA ");
  }

}
