package file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "e:\\javafiletest\\t1.jpg";
        String destFilePath = "e:\\javafiletest\\t2.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组提高读取效率
            byte[] buf = new byte[1024];
            int readlen = 0;
            while((readlen = fileInputStream.read(buf)) != -1){
                //读取到文件后，就写入到文件中，即一边读一边写
                fileOutputStream.write(buf,0,readlen);//一定要使用这个方法！(因为最后不一定写入1024个字节)
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
