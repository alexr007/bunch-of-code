package web.entities;

public class Product {
    private final String url;
    private final String name;

    public Product(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
