package jdbc_;

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
public class PreparedStatementDML_ {
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

        String sql = "insert into admin values(?,?)";
        String sql2 = "update admin set pwd = ? where name = ?";
        String sql3 = "delete from admin where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql3);
        preparedStatement.setString(1,admin_name);
        //preparedStatement.setString(2,admin_pwd);

        int rows= preparedStatement.executeUpdate();
        System.out.println(rows>0 ? "执行成功" :"执行失败");

        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
