package guice;

public class ProcessorProd implements Processor {

  @Override
  public String value() {
    return "prod";
  }
}
