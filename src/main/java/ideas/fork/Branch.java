package ideas.fork;

/**
 * Created by mac on 25.05.2017.
 */
public class Branch implements Doable {
    private final boolean condition;
    private final Doable origin;

    public Branch(boolean condition, Doable origin) {
        this.condition = condition;
        this.origin = origin;
    }

    @Override
    public void make() {
        if (condition) {
            origin.make();
        }
    }
}
