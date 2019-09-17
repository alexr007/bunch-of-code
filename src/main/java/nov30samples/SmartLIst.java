package nov30samples;

import java.util.List;

public class SmartLIst {
  private List<Integer> values;

  public int size() {
    return values.size();
  }

  public boolean add(Integer integer) {
    return values.add(integer);
  }

  public boolean remove(Object o) {
    return values.remove(o);
  }

  public void clear() {
    values.clear();
  }
}
