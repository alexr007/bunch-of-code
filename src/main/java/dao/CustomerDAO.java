package dao;

import javax.sql.RowSet;
import java.util.Collection;

public interface CustomerDAO {
    int insertCustomer();
    boolean deleteCustomer(Customer c);
    Customer findCustomer();
    boolean updateCustomer(Customer c);
    RowSet selectCustomersRS();
    Collection selectCustomersTO(Customer c);
}