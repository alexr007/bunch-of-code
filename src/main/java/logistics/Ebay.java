package logistics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ebay {
  /**
   * everything between ''
   */
  private static Pattern EXTRACTOR_PARENTHESIS = Pattern.compile("'(.*?)'");
  /**
   * any 12 digit number
   */
  private static Pattern EXTRACTOR_EBAY_NUMBER = Pattern.compile("\\b\\d{12}\\b");

  public Optional<String> extract_id(String origin) {
    Matcher matcher = EXTRACTOR_EBAY_NUMBER.matcher(origin);
    if (matcher.find()) {
      return Optional.of(matcher.group(0));
    }
    return Optional.empty();
  }

  public static void main(String[] args) {
    Ebay ebay = new Ebay();
    List<String> test = Arrays.asList(
        "'# 352624904606'",
        "(123456789012)",
        "(123456789012)ab",
        "a (123456789012) b"
    );
    test.forEach(n -> {
      System.out.println(ebay.extract_id(n));
    });
  }
}
