package interview.booking;

public class Problem1 {

  public static String getShiftedString(String orig, int leftShifts, int rightShifts) {
    int len = orig.length();
    int total = (rightShifts - leftShifts) % len;
    if (total > 0) {
      String part1 = orig.substring(0, len - total);
      String part2 = orig.substring(len - total);
      return part2.concat(part1);
    }
    if (total < 0) {
      String part1 = orig.substring(0, -total);
      String part2 = orig.substring(-total);
      return part2.concat(part1);
    }
    return orig;
  }
}
