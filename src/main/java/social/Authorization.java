package social;

public class Authorization {
    private final Auth auth;

    public Authorization(Auth auth) {
        this.auth = auth;
    }

    public void doit() {
        auth.login2("","");
    }
}
