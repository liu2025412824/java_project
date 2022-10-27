package jdbc_.JDBCUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static代码块中去初始化
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\jdbc_\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，可以这样处理
            //1.将编译异常转成运行异常
            //2.这时调用者 可以选择捕获该异常，也可以选择默认处理该异常，比较方便
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    //关闭相关资源
    //1.ResultSet结果集 2.Statement或PreparedStatement 3.Connection
    //4.如果需要关闭资源，就传入对象，否则就传入null
    public static void close(ResultSet set, Statement statement,Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
