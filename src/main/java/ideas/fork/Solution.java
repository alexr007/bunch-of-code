package ideas.fork;

/**
 * Created by mac on 25.05.2017.
 */
public class Solution<T> {
    private final boolean condition;
    private final T ifTrue;
    private final T ifFalse;

    public Solution(boolean condition, T ifTrue, T ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public T make() {
        return condition ? ifTrue : ifFalse;
    }
}
