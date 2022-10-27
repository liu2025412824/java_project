package file.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Lzy
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {

        String directoryPath = "e:\\javafiletest\\test1";
        File file1 = new File(directoryPath);
        if(!file1.exists()){
            if(file1.mkdirs()){
                System.out.println(directoryPath+"创建成功~");
            }else{
                System.out.println(directoryPath+"创建失败~");
            }
        }

        String filePath = directoryPath+"\\hello.txt";
        File file2 = new File(filePath);
        if(!file2.exists()){
            if(file2.createNewFile()){
                System.out.println(filePath+"创建成功~");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
                bw.write("hello,world");
                bw.close();
                System.out.println("写入成功~");
            }else{
                System.out.println(filePath+"创建失败~");
            }
        }else{
            System.out.println(filePath+"文件已存在，不必重复创建~");
        }
    }
}