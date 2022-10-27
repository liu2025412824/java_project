package qqserver.service;

import qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lzy
 * @version 1.0
 */
public class OffLineMessageService {

    private static ConcurrentHashMap<String, ArrayList<Message>> offLineMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getOffLineMap() {
        return offLineMap;
    }
    public static void setOffLineMap(ConcurrentHashMap<String, ArrayList<Message>> offLineMap) {
        OffLineMessageService.offLineMap = offLineMap;
    }

    //将离线消息存入到集合中
    //编写getter不在线时，将离线消息添加到offlineMap
    public static void addOfflineMap(Message message){
        //如果getter不存在 那么创建一个ArrayList 并将message放入
        if(!offLineMap.containsKey(message.getGetter())){
            ArrayList<Message> messages = new ArrayList<>();
            messages.add(message);
            offLineMap.put(message.getGetter(), messages);
        }else{
            ArrayList arrayList = offLineMap.get(message.getGetter());
            arrayList.add(message);
        }
        System.out.println("离线消息已经放到offlineMap中");
    }
    //编写方法,当有新用户登录验证成功后
    // 判断该user是否存在于offlineMap中，如果存在，就获取对应getter的socket将ArrayList中的所有内容发送
    public static void sendOfflineMessage(String userId,ConcurrentHashMap offineMap){
        if(offLineMap.containsKey(userId)){
            ArrayList<Message> arrayList = (ArrayList<Message>)offineMap.get(userId);
            try {
                ObjectOutputStream oos=
                        new ObjectOutputStream(ManageClientThreads.getServerConnectClientThread(userId).getSocket().getOutputStream());
                //将message集合发送到客户端
                oos.writeObject(arrayList);
                System.out.println("发送成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("离线消息发送失败(无离线消息)");
        }
    }

    //编写方法判断getter是否在线
    public static boolean isOnline(String getterID){
        HashMap<String,ServerConnectClientThread> hm = ManageClientThreads.getHm();
        return hm.containsKey(getterID);
    }

    //将离线消息从offlineMap删除
    public static void deleteOfflineMap(String gettrerId){
        ArrayList remove = offLineMap.remove(gettrerId);
        System.out.println("删除消息成功"+remove);
    }

}
