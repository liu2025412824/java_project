package jdbc_;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //注册驱动
        Driver driver = new Driver();
        //得到连接
        String url = "jdbc:mysql://localhost:3306/lzy_db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","0000");
        Connection connection = driver.connect(url,properties);
        //执行sql
        String sql = "insert into actor values(null,'刘德华','男','1970-11-11','12306')";
        //String sql = "update actor set name = '刘大柱' where id=1";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows>0 ? "成功" : "失败");

        //关闭连接资源
        statement.close();
        connection.close();
    }
}
