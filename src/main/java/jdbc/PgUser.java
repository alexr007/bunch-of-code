package jdbc;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.SingleOutcome;

import javax.sql.DataSource;
import java.sql.SQLException;

public class PgUser implements User {
    private final DataSource base;
    private final long number;

    public PgUser(DataSource dbase, long number) {
        this.base = dbase;
        this.number = number;
    }

    @Override
    public long id() {
        return this.number;
    }

    @Override
    public String login() throws SQLException {
        return new JdbcSession(this.base)
                .sql("SELECT u_login FROM users WHERE u_id = ?")
                .set(this.number)
                .select(new SingleOutcome<String>(String.class));
    }

    @Override
    public String email() throws SQLException {
        return new JdbcSession(this.base)
                .sql("SELECT u_email FROM users WHERE u_id = ?")
                .set(this.number)
                .select(new SingleOutcome<String>(String.class));
    }
}
