package jdbc;

public class Triple {
    private final long id;
    private final String login;
    private final String email;

    public Triple(long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public long id() {
        return id;
    }

    public String login() {
        return login;
    }

    public String email() {
        return email;
    }
}
