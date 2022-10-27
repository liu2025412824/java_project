package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String filename)
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent,String child)//根据父目录文件+子路径构建
    @Test
    public void creat02(){
        File parentFile = new File("e:\\");
        String filename = "news2.txt";
        //这里的file对象，在Java程序中只是一个对象
        //只有执行了creatNewFile()方法，才会真正的在磁盘创建文件
        File file = new File(parentFile,filename);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent,String child)//根据父目录+子路径构建
    @Test
    public void creat03(){
        //String parentPath = "e:\\";
        String parentPath = "e:/";
        String filename = "news3.txt";
        File file = new File(parentPath,filename);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
