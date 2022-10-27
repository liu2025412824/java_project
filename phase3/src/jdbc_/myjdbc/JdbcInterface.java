package jdbc_.myjdbc;

/**
 * @author Lzy
 * @version 1.0
 */
public interface JdbcInterface {
    public void getConnection();
    public void curd();
    public void close();
}
