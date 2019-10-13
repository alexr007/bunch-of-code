package danit.javatests.normalizer.model.outcome;

import com.jcabi.jdbc.Outcome;
import danit.javatests.normalizer.model.dto.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutcomeUser implements Outcome<User> {
    @Override
    public User handle(ResultSet r, Statement stmt) throws SQLException {
        User u = new User();
        if (r.next()) {
            u.setId(r.getInt("u_id"));
            u.setName(r.getString("u_name"));
            u.setDate(r.getTimestamp("u_regdate"));
            u.setLogin(r.getString("u_login"));
            u.setPasswd(r.getString("u_passwd"));
            u.setGroupId(r.getInt("u_group"));
        }
        return u;
    }
}
