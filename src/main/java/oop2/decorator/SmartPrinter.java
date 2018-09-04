package oop2.decorator;

public class SmartPrinter implements Printable {
    private final Printable p;
    private final String s1;
    private final String s2;

    public SmartPrinter(SimplePrinter simplePrinter) {
        this(simplePrinter, "HEADER", "FOOTER");
    }

    public SmartPrinter(Printable p, String header, String footer) {
        this.p = p;
        this.s1 = header;
        this.s2 = footer;
    }

    @Override
    public void print() {
        System.out.println(s1);
        p.print();
        System.out.println(s2);
    }
}
