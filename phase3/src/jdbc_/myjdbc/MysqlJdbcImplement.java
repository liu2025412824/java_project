package jdbc_.myjdbc;

/**
 * @author Lzy
 * @version 1.0
 */
public class MysqlJdbcImplement implements JdbcInterface{

    @Override
    public void getConnection() {
        System.out.println("与Mysql建立连接...");
    }

    @Override
    public void curd() {
        System.out.println("对MYsql进行增删改查");
    }

    @Override
    public void close() {
        System.out.println("与Mysql断开连接...");
    }
}
