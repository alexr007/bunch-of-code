package ideas.forkable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 25.05.2017.
 */
public class Fork implements Doable{
    private List<Branch> branches;

    public Fork(Branch... branches) {
        this.branches = new ArrayList<>(Arrays.asList(branches));
    }

    public void do_() {
        branches.forEach(item -> item.do_());
    }
}
