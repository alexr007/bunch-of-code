package flatmap;

public class XPair<A, B> {
  private final A v1;
  private final B v2;

  public static <A, B> XPair of(A v1, B v2) {
    return new XPair<>(v1, v2);
  }

  public XPair(A v1, B v2) {
    this.v1 = v1;
    this.v2 = v2;
  }

  public A v1() {
    return v1;
  }

  public B v2() {
    return v2;
  }

  @Override
  public String toString() {
    return String.format("[%s:%s]", v1, v2);
  }
}
