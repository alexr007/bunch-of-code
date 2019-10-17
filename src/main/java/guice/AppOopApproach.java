package guice;

public class AppOopApproach {
  public static void main(String[] args) {
    Processor processor =
//        new ProcessorTest();
        new ProcessorProd();
    System.out.println(processor.value());
  }
}
