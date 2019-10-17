package guice;

public class ProcessorTest implements Processor {

  private final String val;

  public ProcessorTest() {
    this("test");
  }

  public ProcessorTest(String val) {
    this.val = val;
  }

  @Override
  public String value() {
    return val;
  }
}
