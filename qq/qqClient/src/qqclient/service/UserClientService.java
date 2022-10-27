package qqclient.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Lzy
 * @version 1.0
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    //因为我们可能在其他的地方使用user信息，因此做成成员属性
    private User u = new User();
    //我们也可能在其他地方使用socket，因此做成成员属性
    Socket socket = null;

    //根据userid和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);

        //连接到服务端，发送u对象
        try {
            socket = new Socket(InetAddress.getByName("172.33.138.60"),9999);
            //得到ObjectOuputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message)ois.readObject();

            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //创建一个和服务器端保持通信的线程 -> 创建一个类ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                //启动客户端的线程
                ccst.start();
                //这里为了后面客户端的扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,ccst);
                b = true;
            }else{
                //如果登陆失败，我们就不能启动和服务器通信的线程，关闭Socket
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    //向服务器端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());

        //发送给服务器
        //应当得到当先线程的Socket对应的ObjeOutputStream对象
        try {
            //一句话写完此句
            //ObjectOutputStream oos =
                    //new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            //从管理线程的集合中通过userId，得到这个线程对象
            ClientConnectServerThread ccst = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //通过这个线程得到关联的socket
            Socket socket = ccst.getSocket();
            //得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送一个Message对象，向服务端要求在线用户列表
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法，退出客户端，并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());

        //发送message
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+" 退出系统...");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
