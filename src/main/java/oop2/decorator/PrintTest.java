package oop2.decorator;

public class PrintTest {
    public static void main(String[] args) {
        Printable p1 = new SmartPrinter(new SimplePrinter(), "header11", "footer11");
        Printable p2 = new SmartPrinter(new SimplePrinter());
        p1.print();
        p2.print();
    }
}
