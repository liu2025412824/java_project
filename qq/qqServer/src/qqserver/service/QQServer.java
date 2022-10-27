package qqserver.service;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lzy
 * @version 1.0
 * 这是服务器，在监听9999，等待客户端的连接，并保持通信
 */
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，如果是这些用户登录，就认为是合法
    //这里我们也可以使用ConcurrentHashMap,可以处理并发的集合，没有线程安全
    //HashMap 没有处理线程安全，因此在多线程情况下是不安全
    //ConcurrentHashMap 处理的线程安全，及线程同步处理，在多线程情况下是安全
    private static HashMap<String,User> validUsers = new HashMap<>();

    static{ //在静态代码块，初始化validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }

    //验证用户是否有效的方法
    private boolean CheckUser(String userId,String passwd){
        User u = validUsers.get(userId);
        //过关的验证方式
        if(u == null){
            return false;
        }
        if(!u.getPasswd().equals(passwd)){
            return false;
        }
        return true;
    }

    public QQServer(){
        //注意：端口可以配置文件中
        try {
            System.out.println("服务端在9999端口监听...");
            ss = new ServerSocket(9999);
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();

            while(true){
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User)ois.readObject();//读取客户端发送的User对象
                Message message = new Message();
                //验证
                if(CheckUser(u.getUserId(), u.getPasswd())){//登陆通过
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复客户端
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信，该线程需要持有Socket对象
                    ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    scct.start();
                    // 把该线程对象放入到一个集合中，进行管理
                    ManageClientThreads.addClientThread(u.getUserId(),scct);
                    ConcurrentHashMap<String,ArrayList<Message>> offlineMap = OffLineMessageService.getOffLineMap();
                    //发送离线消息
                    OffLineMessageService.sendOfflineMessage(u.getUserId(),offlineMap);
                    OffLineMessageService.deleteOfflineMap(u.getUserId());

                }else{//登录失败
                    System.out.println("用户 id="+u.getUserId()+" pwd="+u.getPasswd()+" 验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    socket.close();//关闭socket
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端退出了while循环，说明服务端不再监听，因此关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
