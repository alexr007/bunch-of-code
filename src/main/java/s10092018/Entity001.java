package s10092018;

public interface Entity001<T> {
  boolean has();
  String message();
  T get();
  String json();

  public class Ok implements Entity001<String> {
    private final String origin;

    public Ok(String origin) {
      this.origin = origin;
    }

    @Override
    public boolean has() {
      return true;
    }

    @Override
    public String message() {
      throw new IllegalArgumentException();
    }

    @Override
    public String get() {
      return origin;
    }

    @Override
    public String json() {
      return null;
    }
  }

  public class Error implements Entity001<String> {
    private final String msg;

    public Error(String msg) {
      this.msg = msg;
    }

    @Override
    public boolean has() {
      return false;
    }

    @Override
    public String message() {
      return msg;
    }

    @Override
    public String get() {
      throw new IllegalArgumentException();
    }

    @Override
    public String json() {
      return null;
    }
  }
}
