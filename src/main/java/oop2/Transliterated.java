package oop2;

public class Transliterated  {
    private final String origin;

    public Transliterated(String origin) {
        this.origin = origin;
    }

    public CharSequence value() {
        return origin.toUpperCase();
    }
}
