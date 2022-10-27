package jdbc_.datesource;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import jdbc_.JDBCUtils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

/**
 * @author Lzy
 * @version 1.0
 */
public class ConQuestion {

    //连接mysql 5000次
    @Test
    public void testCon(){
        long start = System.currentTimeMillis();
        System.out.println("开始连接...");
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            //做一些工作，例得到PreparedStatement,发送sql......
            JDBCUtils.close(null,null,connection);

        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式连接5000次 耗时"+(end-start));
    }
}
