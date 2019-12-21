package logistics.amt.number;

import java.util.Map;

public class NumberDetails {

  private final static String NOT_FOUND = "No Part Found";

  @SuppressWarnings("unchecked")
  public static NumberDetails from(Object origin) {
    return from((Map<String, Object>)origin);
  }

  public static NumberDetails from(Map<String, Object> origin) {
    return NOT_FOUND.equals(origin.get("descr"))
        ? new NumberDetailsEmpty((String) origin.get("oem"))
        : new NumberDetailsFull(origin);
  }

}
