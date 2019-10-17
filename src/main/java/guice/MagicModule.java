package guice;

import com.google.inject.AbstractModule;

public class MagicModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Processor.class)
        .to(ProcessorProd.class);
  }
}
