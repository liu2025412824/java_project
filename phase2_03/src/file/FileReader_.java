package file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\javafiletest\\story.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            fileReader = new FileReader(filePath);
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
    }

    @Test
    public void readFile02() throws IOException {
        String filePath = "e:\\javafiletest\\story.txt";
        FileReader fileReader = null;
        int readlen = 0;
        char[] buf = new char[8];
        try {
            fileReader = new FileReader(filePath);
            //循环读取，使用read(buf),返回的是实际读取到的字符数
            //如果返回-1，说明文件结束
            while((readlen = fileReader.read(buf)) != -1){
                System.out.print(new String(buf,0,readlen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
    }
}
