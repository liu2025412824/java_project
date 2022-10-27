package file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Lzy
 * @version 1.0
 */
public class Directory_ {
    public static void main(String[] args) {

    }

    @Test
    public void m1(){
        File file = new File("e:\\news2.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("文件删除成功");
            }else {
                System.out.println("文件删除失败");
            }
        }else{
            System.out.println("文件不存在");
        }
    }

    // 在Java编程中，目录也被当作文件
    @Test
    public void m2(){
        File file = new File("e:\\demo");
        if(file.exists()){
            if(file.delete()){
                System.out.println("文件删除成功");
            }else {
                System.out.println("文件删除失败");
            }
        }else{
            System.out.println("文件不存在");
        }
    }

    @Test
    public void m3(){
        File file = new File("e:\\demo\\a\\b\\c");
        if(file.exists()){
            System.out.println("存在...");
        }else{
            if(file.mkdirs()){  //创建多级目录使用mkdirs(),创建一级目录使用mkdir()
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        }
    }
}
