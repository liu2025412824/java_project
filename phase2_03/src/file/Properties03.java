package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        //创建
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","8888");

        //将k-v存储文件中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"),"我是一个备注");
        System.out.println("保存配置文件成功!");
    }
}
