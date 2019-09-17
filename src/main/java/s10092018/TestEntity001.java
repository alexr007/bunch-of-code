package s10092018;

public class TestEntity001 implements Constants007 {
  public static Entity001 sample1() {
    return new Entity001.Ok("OKAY");
  }

  public static Entity001 sample2() {
    return new Entity001.Error("Strange things happen");
  }

  public static void behavior(Entity001 e) {
    if (e.has()) {
      System.out.println("OBJECT:"+e.get());
      e.json();
    } else {
      System.out.println("ERROR:"+e.message());
    }
  }

  public static void main(String[] args) {
    Entity001 s1 = sample1();
    Entity001 s2 = sample2();
    behavior(s1);
    behavior(s2);
    String s = COMMENT;
  }
}
