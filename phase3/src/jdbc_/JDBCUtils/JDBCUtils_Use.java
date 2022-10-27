package jdbc_.JDBCUtils;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * @author Lzy
 * @version 1.0
 * 该类演示如何使用JDBCUtils工具类,完成dml和select
 */
public class JDBCUtils_Use {

    public static void main(String[] args) {

    }

    @Test
    public void testDML(){
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql语句
        String sql = "update actor set name=? where id=?";
        //测试
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"刘德华");
            preparedStatement.setInt(2,2);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行，得到结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate+"\t"+phone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(set,preparedStatement,connection);
        }

    }
}
