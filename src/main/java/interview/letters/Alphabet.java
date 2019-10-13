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

        List<String> bitmap;

        Letters(String... bmp) {
            bitmap = Arrays.asList(bmp);
        }

        List<String> strings() {
            return bitmap;
        }
    }

    private final String SPACE = " ";
    private final String origin;
    private final Map<Character, Letters> bitmaps =
            Stream.of(Letters.values())
            .filter(l -> !l.equals(Letters.None))
            .collect(Collectors.toMap(
                    letters -> letters.toString().charAt(0),
                    letters -> letters
            ));

    public Alphabet(String abc) {
        this.origin = abc;
    }

    List<String> data() {
        List<List<String>> word = origin.chars()
                .mapToObj(c -> bitmaps.getOrDefault((char) c, Letters.None).strings())
                .collect(Collectors.toList());

        return IntStream.range(0, word.get(0).size())
                .mapToObj(idx -> word.stream().map(strings -> strings.get(idx)).collect(Collectors.joining(SPACE)))
                .collect(Collectors.toList());
    }

    void print() {
        List<String> bitmap = data();
        bitmap.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new Alphabet(" ABCBA ").print();
    }

}
