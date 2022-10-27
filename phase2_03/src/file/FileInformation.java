package file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Lzy
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info(){
        File file = new File("e:\\news1.txt");

        System.out.println("文件的名字："+file.getName());
        System.out.println("文件的绝对路径："+file.getAbsolutePath());
        System.out.println("文件的父级目录："+file.getParent());
        System.out.println("文件的大小(字节)："+file.length());
        System.out.println("文件是否存在："+file.exists());
        System.out.println("是不是一个文件："+file.isFile());
        System.out.println("是不是一个目录："+file.isDirectory());
    }
}
