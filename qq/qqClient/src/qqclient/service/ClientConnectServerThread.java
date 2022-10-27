package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Lzy
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread{
    //该线程需要持有Socket
    private Socket socket;

    //构造器可以接受一个Socket对象
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为Thread需要在后台和服务器通信，因此需要while循环
        while(true){
            try {
                System.out.println("客户端线程，等待读取从服务端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送Message对象，线程会阻塞在这里
                //Message message = (Message)ois.readObject();//实现离线留言功能前
                Object o = ois.readObject();//如果服务器没有发送object对象，线程会阻塞在这里
                if(o instanceof ArrayList){
                    ArrayList<Message> messagearrayList = (ArrayList<Message>)o;
                    System.out.println("以下是您的离线消息：↓");
                    Iterator<Message> iterator = messagearrayList.iterator();
                    while(iterator.hasNext()){
                        Message message = iterator.next();
                        System.out.println(message.getSender()+" :"+message.getContent());
                    }
//                    for(Message message:messagearrayList){
//                        System.out.println(message.getSender()+" :"+message.getContent());
//                    }
                }else {
                    Message message = (Message)o;
                    //判断这个message类型，然后做相应的业务处理
                    //如果读取到的是服务端返回的在线用户列表
                    if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                        String[] onlineUsers = message.getContent().split(" ");
                        System.out.println("\n============当前在线用户列表============");
                        for (int i = 0; i < onlineUsers.length; i++) {
                            System.out.println("用户：" + onlineUsers[i]);
                        }
                    } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                        //把从服务器转发的消息，显示到控制台即可
                        System.out.println("\n" + message.getSender() +
                                " 对 " + message.getGetter() + " 说：" + message.getContent());
                    } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                        System.out.println("\n" + message.getSender() + " 对大家说：" + message.getContent());
                    } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                        System.out.println("\n" + message.getSender() + " 给 " + message.getGetter() +
                                " 发送文件：" + message.getSrc() + " 到我的电脑的目录：" + message.getDest());

                        //取出message的文件字节数组，通过文件输出流写出到磁盘
                        FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                        fileOutputStream.write(message.getFileBytes());
                        fileOutputStream.close();
                        System.out.println("\n 保存文件成功~");
                    } else {
                        System.out.println("是其它类型的message，暂时不处理");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //  为了更方便的得到Socket
    public Socket getSocket() {
        return socket;
    }
}
