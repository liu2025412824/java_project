package file;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 单个字节读取，效率比较低
     * ->使用read(byte[] b)
     */
    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\JavaFileTest\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //如果返回-1，表示读取完毕
            while((readData = fileInputStream.read()) != -1){
                System.out.print((char)readData);//转成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\JavaFileTest\\hello.txt";
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];//一次读取8个字节
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            while((readLen = fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));//显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();//关闭文件流，释放资源
        }
    }
    
}
