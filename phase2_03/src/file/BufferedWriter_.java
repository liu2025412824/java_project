package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\javafiletest\\ok.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));//追加模式
        bufferedWriter.write("hello,小同志");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello，小同志2");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,小同志3");
        bufferedWriter.newLine();

        //说明：关闭外层流即可，传入的new FileWriter(filePath)，会在底层关闭
        bufferedWriter.close();
    }
}
