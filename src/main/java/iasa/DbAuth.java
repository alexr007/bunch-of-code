package iasa;

public class DbAuth implements Auth{
    @Override
    public boolean login(String name, String pawd) {
        return true;
    }
}
