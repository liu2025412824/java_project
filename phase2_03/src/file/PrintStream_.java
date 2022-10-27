package file;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Lzy
 * @version 1.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        out.print("hello,world\n");
        out.write("hello".getBytes());

        //关闭流
        out.close();
        //修改打印流输出的位置/设备
        System.setOut(new PrintStream("e:\\javafiletest\\f1.txt"));
        System.out.println("hello,world~");
    }
}
