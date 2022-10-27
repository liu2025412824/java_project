package udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        byte[] data = "hello，明天吃火锅~".getBytes();

        DatagramPacket packet =
                new DatagramPacket(data,data.length, InetAddress.getByName("172.33.142.43"),9999);

        socket.send(packet);

//        byte[] buf = new byte[1024];
//        DatagramPacket packet1 = new DatagramPacket(buf,buf.length);
//        socket.receive(packet1);
//        int len = packet1.getLength();
//        byte[] da = packet1.getData();
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        int len = packet.getLength();
        byte[] da = packet.getData();
        String s = new String(da,0,len);
        System.out.println(s);

        socket.close();
        System.out.println("B端退出..");
    }
}
