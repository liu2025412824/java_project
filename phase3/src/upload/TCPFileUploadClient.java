package upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(),8888);

        String filePath = "e:\\javafiletest\\t1.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = bis.read(buf)) != -1){
            bos.write(buf,0,len);
            //bos.flush();
        }

        bis.close();
        bos.close();
        socket.close();
    }
}
