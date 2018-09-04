package ideas.forkable;

/**
 * Created by mac on 25.05.2017.
 */
public class Branch implements Doable{
    private final boolean condition;
    private final Doable doable;

    public Branch(boolean condition, Doable doable) {
        this.condition = condition;
        this.doable = doable;
    }

    public void do_() {
        if (condition) {
            doable.do_();
        }
    }
}
