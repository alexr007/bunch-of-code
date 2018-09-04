package dao;

public abstract class DAOFactory {
    public static final int CLOUDSCAPE = 1;
    public static final int ORACLE = 2;
    public static final int SYBASE = 3;
    public static final int DAOCLOUDSCAPE = 4;

    public abstract CustomerDAO getCustomerDAO();
    //public abstract AccountDAO getAccountDAO();
    //public abstract OrderDAO getOrderDAO();

    public static DAOFactory get(int whichFactory) {
        switch (whichFactory) {
            case CLOUDSCAPE: return new CloudscapeDAOFactory();
            case ORACLE    : return new OracleDAOFactory();
            case SYBASE    : return new SybaseDAOFactory();
            default        : return null;
        }
    }
}