package oop2;

import java.util.function.Consumer;

public class ConsumerDoable implements Consumer<Doable> {
    @Override
    public void accept(Doable doable) {
        doable.doIt();
    }
}
