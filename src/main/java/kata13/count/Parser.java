package kata13.count;

public class Parser {

  public static String squashWs(String s) {
    return s.replaceAll("\\s","");
  }

  public static boolean containsOpenTag(String s) {
    return s.contains("/*");
  }

  public static boolean containsCloseTag(String s) {
    return s.contains("*/");
  }

  public static boolean containsRowComment(String s) {
    return s.contains("//");
  }

  public static String dropRowComment(String s) {
    return containsRowComment(s) ? s.substring(0, s.indexOf("//")) : s;
  }

}
