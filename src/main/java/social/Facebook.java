package social;

import java.util.List;

public class Facebook implements Auth, NewsLine {
    @Override
    public boolean login(String name, String pwd) {
        return false;
    }

    @Override
    public boolean login2(String name, String pwd) {
        return false;
    }

    @Override
    public List<String> line() {
        return null;
    }
}
