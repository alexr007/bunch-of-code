package stack.gen2;

import java.util.Set;

public class Clazz extends AbstractClass{
    private Set<Weapon> items;

    public Clazz(Set<Weapon> items) {
        this.items = items;
    }

    @Override
    Set getItems() {
        return items;
    }
}






