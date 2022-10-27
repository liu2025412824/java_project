package file;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {

        String srcFilePath = "e:\\javafiletest\\t1.jpg";
        String destFilePath = "e:\\javafiletest\\t3.jpg";
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            //因为FileInputStream 是 InputSteam子类
            bi = new BufferedInputStream(new FileInputStream(srcFilePath));
            bo = new BufferedOutputStream(new FileOutputStream(destFilePath));
            //读写[从使用上和前面学习的FileInputStream和FileOutputStream一样]
            byte[] buf = new byte[1024];
            int len = 0;

            while((len = bi.read(buf)) != -1){
                bo.write(buf,0,len);
            }
            System.out.println("文件拷贝完成...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            bi.close();
            bo.close();
        }
    }
}
