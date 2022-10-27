package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Lzy
 * @version 1.0
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\javafiletest\\d.txt";
        String charSet = "gbk";

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),charSet);
        osw.write("hello小同志");

        osw.close();
        System.out.println("文件以"+charSet+"格式保存完毕...");
    }
}
