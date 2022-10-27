package jdbc_.datesource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ha.selector.DataSourceSelectorFactory;
import jdbc_.JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class DBUtils_use {

    //使用apache——DBUtils工具类+druid完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException {
        //1.得到 连接(druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils类和接口，先引入DBUtils 相关的jar，加入到本Projet
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.执行相关的方法，返回ArrayList结果集
        String sql = "select * from actor where id >= ?";
        List<Actor> list = queryRunner.query(connection,sql,new BeanListHandler<>(Actor.class),1);
        System.out.println("输出集合的信息");
        for(Actor actor:list){
            System.out.print(actor);
        }

        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }

    //返回单行多列的记录
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id = ?";
        Actor actor = queryRunner.query(connection,sql,new BeanHandler<>(Actor.class),2);
        System.out.println(actor);

        JDBCUtilsByDruid.close(null,null,connection);
    }

    //返回单行单列的记录，返回的是Object
    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        Object object = queryRunner.query(connection,sql,new ScalarHandler<>(),2);
        System.out.println(object);

        JDBCUtilsByDruid.close(null,null,connection);
    }

    //演示apache—dbutils+druid完成dml的操作
    @Test
    public void testDML() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = ds.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql1 = "update actor set name=? where id =?";
        String sql2 = "insert into actor values(null,?,?,?,?)";
        String sql3 = "delete from actor where id = ?";
        //返回的是受影响的行数
        //int affectedRow = queryRunner.update(connection,sql1,"王建国",1);
        //int affectedRow =queryRunner.update(connection,sql2,"林青霞","女","1996-10-10","12123");
        int affectedRow = queryRunner.update(connection,sql3,4);
        System.out.println(affectedRow>0 ? "执行成功" : "执行没有影响表");

        JDBCUtilsByDruid.close(null,null,connection);
  }
}
