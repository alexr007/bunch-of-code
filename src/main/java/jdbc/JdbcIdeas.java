package jdbc;

import com.jcabi.jdbc.*;
import com.jolbox.bonecp.BoneCPDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class JdbcIdeas {
    public static void main3(String[] args) throws SQLException {
        System.out.println("JDBC ideas");

        String url = "jdbc:postgresql://localhost/avtomir";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","pg123457");
        props.setProperty("ssl","false");

        Connection conn = DriverManager.getConnection(url, props);
        StaticSource src = new StaticSource(conn);

        String name = new JdbcSession(src)
                .sql("SELECT u_login FROM users WHERE u_id = ?")
                .set(6)
                .select(new SingleOutcome<String>(String.class));
        System.out.printf("selected data is:%s\n",name);

        conn = DriverManager.getConnection(url, props);
        src = new StaticSource(conn);
        Collection<String> list = new JdbcSession(src)
                .sql("SELECT u_login FROM users WHERE u_id<20")
                .select(new ColumnOutcome<String>(String.class));

        list.forEach(s -> System.out.printf("item is:%s\n", s));

    }

    public static void main(String[] args) throws SQLException {
        System.out.println("JDBC ideas");

        BoneCPDataSource src = new BoneCPDataSource();
        src.setDriverClass("org.postgresql.Driver");
        src.setJdbcUrl("jdbc:postgresql://localhost/avtomir");
        src.setUser("postgres");
        src.setPassword("pg123457");

        PgUsers users = new PgUsers(src);
        //users.add("A","B");

        ArrayList<Triple> l = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (User u : users.iterate()) {
            l.add(new Triple(u.id(),u.login(),u.email()));
        }
        long time = System.currentTimeMillis()-start;

        System.out.println(time);
        l.forEach(u -> System.out.printf("Id:%3s, login:%-20s, email:%s\n", u.id(), u.login(), u.email()));

        User u = new PgUser(src, 0);
        System.out.printf("Id:%3s, login:%-20s, email:%s\n", u.id(), u.login(), u.email());


    }
}
