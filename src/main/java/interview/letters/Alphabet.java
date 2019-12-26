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
  private final static Map<Character, Letters> bitmaps = Stream.of(Letters.values())
      .filter(l -> !l.equals(Letters.None))
      .collect(Collectors.toMap(
          letters -> letters.toString().charAt(0),
          letters -> letters
      ));

  public String bitmap(String origin) {
    return IntStream.range(0, Letters.None.bitmap.size()) // iterate over lines
        .mapToObj(ln -> origin.chars()                    // iterate over letters in word
            .mapToObj(ch -> bitmaps.getOrDefault((char) ch, Letters.None).bitmap.get(ln))
            .collect(Collectors.joining(SPACE)))          // join parts of letters to one line with " "
        .collect(Collectors.joining("\n"));      // join resulted lines with "\n"
  }

  public void print(String word) {
    System.out.println(bitmap(word));
  }

  public static void main(String[] args) {
    final Alphabet a = new Alphabet();
    a.print(" ABCBA ");
  }

}
