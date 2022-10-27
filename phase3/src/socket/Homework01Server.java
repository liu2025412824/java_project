package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        String answer = " ";
        if("name".equals(s)){
            answer = "我是年轻的老刘";
        }else if("hobby".equals(s)){
            answer = "basketball";
        }else {
            answer = "你说的啥呀 我听不懂";
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
