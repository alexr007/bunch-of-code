package oop2;

public class Cat implements Doable {
    private String message() {
        return "Meo...";
    }

    @Override
    public void doIt() {
        System.out.println(message());
    }

    public void meo() {
        System.out.println(".....MEOW......");
    }
}
