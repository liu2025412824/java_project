package jdbc_.transaction_;

import jdbc_.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Lzy
 * @version 1.0
 */
public class Transaction_ {

    @Test
    public void useTransaction(){
        Connection connection = null;
        String sql = "update account set balance = balance-100 where id = 1";
        String sql2 = "update account set balance = balance+100 where id = 2";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection(); //在默认情况下，connection默认自动提交
            //将connection设置为不自动提交
            connection.setAutoCommit(false); //开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); //执行第1条sql

            //int i=1/0;//手动制造一个异常测试
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();//执行第2条sql

            //提交事务
            connection.commit();

        } catch (Exception throwables) {
            //这里我们可以进行回滚，即撤销执行的sql
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
