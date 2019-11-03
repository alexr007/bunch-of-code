package implement_;

public final class Child implements Human, Mother, Father {

  @Override
  public String hello() {
    return "it's me!";
  }

}
