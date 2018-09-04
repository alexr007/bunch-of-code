package dao;

import javax.sql.RowSet;
import java.util.Collection;

public class CloudscapeCustomerDAO implements CustomerDAO {

    public CloudscapeCustomerDAO() {
        // initialization
    }

    // The following methods can use
    // CloudscapeDAOFactory.createConnection()
    // to get a conn as required

    public int insertCustomer() {
        // Implement insert customer here.
        // Return newly created customer number
        // or a -1 on error
        return 0;
    }

    public boolean deleteCustomer(Customer c) {
        // Implement delete customer here
        // Return true on success, false on failure
        return true;
    }

    public Customer findCustomer() {
        // Implement find a customer here using supplied
        // argument values as search criteria
        // Return a Transfer Object if found,
        // return null on error or if not found
        return null;
    }

    public boolean updateCustomer(Customer c) {
        // implement update record here using data
        // from the customerData Transfer Object
        // Return true on success, false on failure or
        // error
        return true;
    }

    public RowSet selectCustomersRS() {
        // implement search customers here using the
        // supplied criteria.
        // Return a RowSet.
        return null;
    }

    public Collection selectCustomersTO(Customer c) {
        // implement search customers here using the
        // supplied criteria.
        // Alternatively, implement to return a Collection
        // of Transfer Objects.
        return null;
    }
}