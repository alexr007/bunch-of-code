package iasa;

public class FbAuth implements Auth {
    @Override
    public boolean login(String name, String pawd) {
        return name=="123" && pawd=="123";
    }
}
