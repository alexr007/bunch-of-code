package jdbc;

import java.sql.SQLException;

interface Users {
    Iterable<User> iterate() throws SQLException;
    User add(String login, String email) throws SQLException;
}
