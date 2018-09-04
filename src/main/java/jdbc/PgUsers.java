package jdbc;

import com.jcabi.jdbc.JdbcSession;
import com.jcabi.jdbc.ListOutcome;
import com.jcabi.jdbc.SingleOutcome;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PgUsers implements Users {
    private final DataSource base;

    public PgUsers(DataSource dbase) {
        this.base = dbase;
    }

    @Override
    public Iterable<User> iterate() throws SQLException {
        return new JdbcSession(this.base)
                .sql("SELECT u_id, u_login, u_email FROM users")
                .select(
                        new ListOutcome<User>(
                                new ListOutcome.Mapping<User>() {
                                    @Override
                                    public User map(ResultSet rset) throws SQLException {
                                        return new PgUser(base,
                                                rset.getInt(1)
                                        );
                                    }
                                }
                        )
                );
    }

    @Override
    public User add(String login, String email) throws SQLException {
        return new PgUser(
                this.base,
                new JdbcSession(this.base)
                        .sql("INSERT INTO users (u_login, u_email) VALUES (?, ?)")
                        .set(login)
                        .set(email)
                        .insert(new SingleOutcome<Long>(Long.class))
        );
    }
}
