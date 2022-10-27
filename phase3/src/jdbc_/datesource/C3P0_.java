package jdbc_.datesource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class C3P0_ {

    @Test
    public void testC3P0_01() throws Exception {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件mysql.properties获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\jdbc_\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //给数据源 comboPooledDataSource 设置相关的参数
        //注意：连接是由comboPooledDataSource来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //测试连接池的效率，测试对mysql连接5000次操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法从DataSource接口实现
            //System.out.println("连接成功...");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 连接mysql5000次 耗时="+(end-start));
    }

    @Test
    public void testC3P0_02() throws SQLException {
        //1.加入c3p0 jar包
        //2.加入配置文件 c3p0-config.xml，将该文件拷贝项目的src目录
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("lzy_mysql");

        //测试500000次连接mysql
        long start = System.currentTimeMillis();
        System.out.println("开始执行...");
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("连接成功！");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0的第二种方式 耗时"+(end-start));

    }
}
