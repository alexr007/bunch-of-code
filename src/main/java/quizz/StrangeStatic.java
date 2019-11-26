package quizz;

public class StrangeStatic {
    public static void code() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        ((StrangeStatic)null).code();
    }
}
