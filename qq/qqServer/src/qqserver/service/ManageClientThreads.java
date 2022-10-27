package qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Lzy
 * @version 1.0
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    public static void addClientThread(String userId,ServerConnectClientThread scct){
        hm.put(userId,scct);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    public static String getOnlineUser(){
        //集合遍历，遍历Hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while(iterator.hasNext()){
            onlineUserList += iterator.next().toString()+" ";
        }
        return onlineUserList;
    }

    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }
}
