package concurrency;

public class Product {
    private int count;

    public int get() {
        return count;
    }

    public void inc() {
        this.count++;
    }
}
