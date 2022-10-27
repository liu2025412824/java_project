package upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class MusicServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999窗口监听..等待连接..");
        Socket socket = serverSocket.accept();

        //读取数据通道传来的音乐文件名
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downloadMusicName = "";
        while((len = is.read(b)) != -1){
            downloadMusicName += new String(b,0,len);
            //此处特别值得注意！用的是+=，由于起初定义了" ",导致写出的名都有个空格，所以根本找不到该文件！
            //两种解决思路：1.下次定义String时，不要定义空格，定义为""就行  2.不用+= (视情况而定)
        }
        System.out.println("客户端希望下载的文件名="+downloadMusicName);

        //定义好音乐名的路径
        String resFilePath = " ";
        if("好妹妹".equals(downloadMusicName)){
            resFilePath = "e:\\JavaFileTest\\好妹妹.mp3";
        }else{
            resFilePath = "e:\\JavaFileTest\\好久不见.mp3";
        }

        //从磁盘中读取到对应音乐文件名的二进制数据
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFilePath));
        //byte[] data = StreamUtils.streamToByteArray(bis);
        byte[] data = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int lens = 0;
        while((lens = bis.read(buf)) != -1){
            baos.write(buf,0,lens);
        }
        data = baos.toByteArray();
        baos.close();

        //将音乐数据写入到数据通道，从而传给客户端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        socket.shutdownOutput();

        //关闭相应资源
        bos.close();
        is.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
