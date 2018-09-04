package fs2;

public class Static {
    public static void main1() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        ((Static)null).main1();
    }
}
