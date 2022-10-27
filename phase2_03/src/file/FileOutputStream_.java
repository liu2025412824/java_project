package file;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile() throws IOException {
        String filePath = "e:\\JavaFileTest\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath,false); //(true)当写入内容时，追加到文件后面
            //默认是false，会覆盖，覆盖的意思是，在打开文件时新输入的内容会全覆盖，
            // 但是即使是false，如果以下有多个write语句，每条语句都会追加进去

            //fileOutputStream.write('L');
            String str = "\nhello,world";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(),0,str.length());//"\n"也算一个字符
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
        }
    }
}
