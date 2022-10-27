package upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class TCPFileUploadServer02 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8887);
        System.out.println("服务端在8887端口监听...");
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = bis.read(buf)) != -1){
            baos.write(buf,0,len);
        }
        bytes = baos.toByteArray();
        baos.close();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("e:\\javafiletest\\tt2.jpg"));
        bos.write(bytes);

        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        wr.write("收到图片");
        wr.flush();
        socket.shutdownOutput();

        wr.close();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
