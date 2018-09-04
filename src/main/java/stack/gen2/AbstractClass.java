package stack.gen2;

import java.util.Set;

public abstract class AbstractClass<T extends Item> {
    abstract Set<T> getItems();
}