package upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Lzy
 * @version 1.0
 */
public class MusicClient {
    public static void main(String[] args) throws Exception {
        //获取要下载的文件名
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要下载的文件名：");
        String downloadFileName = input.next();

        //将要下载的文件名传入数据通道
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        OutputStream os = socket.getOutputStream();
        os.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        //从数据通道读取服务端返回的字节数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //byte[] data = StreamUtils.streamToByteArray(bis);
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = bis.read(buf)) != -1){
            baos.write(buf,0,len);
        }
        data = baos.toByteArray();
        baos.close();

        //将数据写入磁盘文件
        String filePath = "e:\\javafiletest\\"+downloadFileName+"(2).mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(data);

        //关闭相应资源
        bos.close();
        bis.close();
        os.close();
        socket.close();

        System.out.println("客户端下载完毕，正确退出..");
    }
}
