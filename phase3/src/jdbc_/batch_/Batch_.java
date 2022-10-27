package jdbc_.batch_;

import jdbc_.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Lzy
 * @version 1.0
 */
public class Batch_ {

    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行...");
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,"0000");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时"+(end-start));
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }

    @Test
    public void useBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行...");
        long start = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,"0000");
            //将sql语句加入到批量处理包中
            preparedStatement.addBatch();
            if((i+1) % 1000 == 0){
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理的方式 耗时"+(end-start));
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
