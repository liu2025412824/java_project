package upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听...");
        Socket socket = serverSocket.accept();

        String destFilePath = "e:\\javafiletest\\tt1.jpg";
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = bis.read(buf)) != -1){
            bos.write(buf,0,len);
            //bos.flush();
        }

        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
    }
}
