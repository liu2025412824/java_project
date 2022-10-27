package file;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        //说明：
        //1. BufferedReader和BufferedWriter 是按字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc，pdf 等等]
        String srcFilePath = "e:\\javafiletest\\ok.txt";
        String destFilePath = "e:\\javafiletest\\ok2.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //说明：readLine 读取一行内容，但是没有换行
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("拷贝完毕...");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
            bw.close();
        }
    }
}
