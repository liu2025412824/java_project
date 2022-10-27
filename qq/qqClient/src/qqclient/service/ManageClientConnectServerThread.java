package qqclient.service;

import java.util.HashMap;

/**
 * @author Lzy
 * @version 1.0
 * 该类管理客户端连接到服务器端线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放入一个HashMap集合，key就是用户id，value就是线程
    private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程放入到集合
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread ccst){
        hm.put(userId,ccst);
    }

    //通过userId可以得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }
}
