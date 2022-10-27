package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("客户端 socket返回="+socket.getClass());

        OutputStream os = socket.getOutputStream();
        os.write("hello,server".getBytes());
        //设置写入结束标志
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLine = 0;
        while((readLine = is.read(buf)) != -1){
            System.out.println(new String(buf,0,readLine));
        }

        os.close();
        socket.close();
        System.out.println("客户端退出......");
    }
}