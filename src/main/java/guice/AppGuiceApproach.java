package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class AppGuiceApproach {
  public static void main(String[] args) {
    Injector storage = Guice.createInjector(new MagicModule());

    Processor processor = storage.getInstance(Processor.class);
    System.out.println(processor.value());
  }
}
