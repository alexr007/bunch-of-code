package quizz;

public class Quizz1 {
    public static void print() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        ((Quizz1)null).print();
        System.out.println("B");
    }
}
