package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Lzy
 * @version 1.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\javafiletest\\f2.txt"));
        printWriter.print("hi,misoufamisou");
        //关闭流
        printWriter.close();//flush + 关闭流，才会将数据写入到文件中
    }
}
