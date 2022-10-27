package file;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\javafiletest\\story.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取，效率高
        //1.buffredReader.readLine()是按行读取文件
        //2/当返回null时，表示文件读取完毕
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流，这里注意：只需要关闭BufferedReader,因为底层会自动的去关闭 节点流
        bufferedReader.close();
    }
}
