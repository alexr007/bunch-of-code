package nested_class;

public class A {
  private int a1;
  private int a2;

  class B {
    private int b1;
    private int b2;

    void method() {
      a1 = 1;
//      c1 = 2;
    }
  }

  class C {
    private int c1;
    private int c2;
  }

}
