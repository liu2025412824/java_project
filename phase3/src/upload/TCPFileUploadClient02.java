package upload;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lzy
 * @version 1.0
 */
public class TCPFileUploadClient02 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(),8887);

        String filePath = "e:\\javafiletest\\t1.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = bis.read(buf)) != -1){
            baos.write(buf,0,len);
        }
        bytes = baos.toByteArray();
        baos.close();

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        socket.shutdownOutput();

        BufferedReader brd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = brd.readLine();
        System.out.println(s);

        /* 使用此方法也可以
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int lenn = 0;
        while((lenn = is.read(buf)) != -1){
            System.out.println(new String(buf,0,lenn));
        }
        is.close();*/

        brd.close();
        bos.close();
        bis.close();
        socket.close();
    }
}
