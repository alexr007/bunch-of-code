package danit.javatests.normalizer.model;

import javax.sql.DataSource;
import java.sql.Connection;

public interface DbConn {
    Connection connection();
    DataSource source();
}
