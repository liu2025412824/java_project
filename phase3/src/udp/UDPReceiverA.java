package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Lzy
 * @version 1.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);

        System.out.println("接收端A等待接收数据...");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data,0,length);
        System.out.println(s);

        byte[] da = "好的，明天见~".getBytes();
//        DatagramPacket packet1 =
//                new DatagramPacket(da,da.length, InetAddress.getByName("172.33.142.43"),9998);
//        socket.send(packet1);
        packet =
                new DatagramPacket(da,da.length, InetAddress.getByName("172.33.142.43"),9998);
        socket.send(packet);

        socket.close();
        System.out.println("A端退出..");
    }
}
