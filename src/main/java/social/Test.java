package social;

public class Test {
    public static void main(String[] args) {
        Facebook fb = new Facebook();
        Twitter tw = new Twitter();
        Authorization a1 = new Authorization(tw);
        Authorization a2 = new Authorization(fb);
        a1.doit();
        a2.doit();

    }
}
