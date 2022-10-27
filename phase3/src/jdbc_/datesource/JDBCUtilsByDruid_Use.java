package jdbc_.datesource;

import javafx.beans.binding.ObjectExpression;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lzy
 * @version 1.0
 */
public class JDBCUtilsByDruid_Use {

    @Test
    public void testSelect(){
        //1.得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //2.组织一个sql
        String sql = "select * from actor where id = ?";
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndate+"\t"+phone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);
        }

    }

    @Test
    public ArrayList<Actor>/*void*/ testSelectToArrayList(){
        //1.得到连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //2.组织一个sql
        String sql = "select * from actor where id >= ?";
        ArrayList<Actor> list = new ArrayList<>();
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                //把得到的resultSet的记录，封装到Actor对象，放入到list集合
                list.add(new Actor(id,name,sex,borndate,phone));
            }

            System.out.println("list集合数据="+list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(resultSet,preparedStatement,connection);
        }

        return list;
    }
}
