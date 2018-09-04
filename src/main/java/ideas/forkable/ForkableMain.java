package ideas.forkable;

/**
 * Created by mac on 25.05.2017.
 */
public class ForkableMain {
    public static void main_ugly(String[] args) {
        System.out.println("Forkable ideas...\n");
        int i = 10;
        System.out.println(String.format("i is %d", i));
        if (i > 1) {
            System.out.println("i > 1");
        } else if (i < 1) {
            System.out.println("i < 1");
        } else if (i == 0) {
            System.out.println("i = 0");
        }
    }

    public static void main(String[] args) {
        int i = 10;
        new Fork(
            new Branch(i < 0, new Do1()),
            new Branch(i == 0 , new Do2()),
            new Branch(i>0, new Do3())
        ).do_();
    }

}
