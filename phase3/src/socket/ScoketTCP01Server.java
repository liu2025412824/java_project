package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class ScoketTCP01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器端，在9999端口监听，等待连接...");

        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket ="+socket.getClass());

        InputStream is = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLine = 0;
        while((readLine = is.read(buf)) != -1){
            System.out.println(new String(buf,0,readLine));
        }

        OutputStream os = socket.getOutputStream();
        os.write("hello,client".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        //关闭流和socket
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
    }
}
