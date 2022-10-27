package jdbc_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class JdbcConn {

    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/lzy_db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","0000");
        Connection connection = driver.connect(url,properties);

        System.out.println("方式2="+connection);
    }

    //方式3
    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/lzy_db01";
        String user = "root";
        String password = "0000";

        DriverManager.registerDriver(driver);//注册Driver驱动

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3="+connection);
    }

    //方式4  --用的最多，推荐使用
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/lzy_db01";
        String user = "root";
        String password = "0000";

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("方式4="+connection);
    }

    //方式5
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\jdbc_\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //注册驱动
        Class.forName(driver);//建议写上
        //获取连接
        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("方式5="+connection);
    }
}
