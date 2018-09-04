package ideas.fork;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 25.05.2017.
 */
public class Decision implements Doable {
    private final List<Branch> branches;

    public Decision(Branch... branches) {
        this.branches = Arrays.asList(branches);
    }

    @Override
    public void make() {
        branches.forEach(branch -> branch.make());
    }
}
