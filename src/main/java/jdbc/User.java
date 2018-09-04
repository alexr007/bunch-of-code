package jdbc;

import java.sql.SQLException;

interface User {
    long id();
    String login() throws SQLException;
    String email() throws SQLException;
}
