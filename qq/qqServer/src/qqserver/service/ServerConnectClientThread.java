package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Lzy
 * @version 1.0
 * 该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {//这里线程处于run的状态，可以发送/接收消息

        while(true){
            try {
                System.out.println("服务端和客户端 "+userId+"保持通信，读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //后面会使用到message
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    /*客户端要在线用户列表
                    在线列表形式 100 200 紫霞仙子
                    * */
                    System.out.println(message.getSender()+" 要获取在线用户列表");
                    //写一个获取在线用户列表的方法
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //构建一个Message对象，返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);
                }else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //写一个方法 判断getter是否在线，不在线的话，将message对象存入到集合中
                    if(!OffLineMessageService.isOnline(message.getGetter())){
                        System.out.println("该用户不在线 将在登陆后接收到离线消息");
                        OffLineMessageService.addOfflineMap(message);
                    }else {
                        //根据message获取getterId,然后再得到对应线程
                        ServerConnectClientThread serverConnectClientThread =
                                ManageClientThreads.getServerConnectClientThread(message.getGetter());
                        //得到对应socket的对象输出流，将message对象转发给指定的客户端
                        ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.socket.getOutputStream());
                        oos.writeObject(message);
                    }
                }else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //需要遍历 管理线程的集合，把所有的线程的socket得到，然后把message进行转发
                    HashMap<String,ServerConnectClientThread> hm = ManageClientThreads.getHm();

                    Iterator<String> iterator = hm.keySet().iterator();
                    while(iterator.hasNext()){
                        //取出在线用户的id
                        String onlineUserId = iterator.next().toString();

                        if(!onlineUserId.equals(message.getSender())){//排除群发消息的这个用户
                            //进行转发message
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }

                    }
                }else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageClientThreads.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                    oos.writeObject(message);
                }else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){//客户端退出
                    System.out.println(message.getSender()+" 退出");
                    //将这个客户端对应线程，从集合删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    break;//退出线程
                } else{
                    System.out.println("其它类型的message，暂不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
