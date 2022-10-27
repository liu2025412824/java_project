package jdbc_.myjdbc;

/**
 * @author Lzy
 * @version 1.0
 */
public class TestJdbc {
    public static void main(String[] args){
        //完成对Mysql的操作
        JdbcInterface ji = new MysqlJdbcImplement();
        //动态绑定
        ji.getConnection();
        ji.curd();
        ji.close();
    }
}
