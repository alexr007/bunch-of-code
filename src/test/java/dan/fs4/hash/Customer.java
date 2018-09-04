package dan.fs4.hash;

public class Customer {

    private final int id;
    private final String name;

    Customer(int id) {
        this.id = id;
        this.name = String.format("My name is:%d", id);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean filter() {
        return name.contains("6");
    }
}