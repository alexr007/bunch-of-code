package iasa;

public class Price {
    private final String name;
    private final int price;
    private final String currency;

    public Price(String name, int price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("The %s costs %d %s", this.name, this.price, this.currency);
    }
}
