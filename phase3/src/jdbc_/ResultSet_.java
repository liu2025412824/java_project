package jdbc_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

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
        //得到Stateme
        Statement statement = connection.createStatement();
        //组织sql
        String sql = "select id,name,sex,borndate from actor";
        //执行给定的sql语句，该语句返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        //使用while取出数据
        while (resultSet.next()){  //让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1);//获取该行第1列
            String name = resultSet.getString(2);//获取该行第2列
            String sex = resultSet.getString(3);//3列
            Date date = resultSet.getDate(4);//4列
            System.out.println(id+"\t"+name+"\t"+sex+"\t"+date);
        }
        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
