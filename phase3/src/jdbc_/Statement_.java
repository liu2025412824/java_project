package jdbc_;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Lzy
 * @version 1.0
 */
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner input = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.println("请输入管理员的名字：");
        String admin_name=input.nextLine();
        System.out.println("请输入管理员的密码：");
        String admin_pwd=input.nextLine();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\jdbc_\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        String sql = "select name,pwd from admin where name='"+admin_name+"' and pwd='"+admin_pwd+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){ //如果查询到一条记录，则说明该管理存在
            System.out.println("恭喜，登陆成功");
        }else {
            System.out.println("对不起，登录失败");
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
