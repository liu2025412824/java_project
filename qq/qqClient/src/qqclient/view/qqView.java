package qqclient.view;

import qqclient.service.FileClientService;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;
import qqclient.utils.Utility;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Lzy
 * @version 1.0
 * 这里是客户端
 */
public class qqView {
    private boolean loop = true;//设定退出系统
    private String key = "";//接收用户键盘的输入
    private UserClientService userClientService = new UserClientService();//对象用于登陆服务器/注册用户
    private MessageClientService messageClientService = new MessageClientService();//对象用于私聊/群聊
    private FileClientService fileClientService = new FileClientService();//该对象用于传输文件

    public static void main(String[] args) {
        new qqView().mainMenu();
        System.out.println("客户端退出系统.....");
    }

    public void mainMenu(){
        while(loop) {

            System.out.println("===================欢迎登录网络通信系统=================");
            System.out.println("\t\t 1.登陆系统");
            System.out.println("\t\t 9.退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            //根据用户的输入，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);
                    //这里比较麻烦，需要到服务端去验证该用户是否合法
                    //这里有很多代码，编写一个类 UserClientService[用户登录/注册]
                    if(userClientService.checkUser(userId,pwd)){
                        System.out.println("==================欢迎(用户 "+userId+") 登陆成功=================");
                        while(loop){
                            System.out.println("=============网络通信系统二级菜单(用户 "+userId+")=============");
                            System.out.println("\t\t 1.显示在线用户列表");
                            System.out.println("\t\t 2.群发消息");
                            System.out.println("\t\t 3.私聊消息");
                            System.out.println("\t\t 4.发送文件");
                            System.out.println("\t\t 9.退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    //System.out.println("显示在线用户列表");
                                    //写一个方法来获取在线用户列表
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    //System.out.println("群发消息");
                                    System.out.println("请输入想对大家说的话：");
                                    String s = Utility.readString(100);
                                    messageClientService.sendMessageToAll(s,userId);
                                    break;
                                case "3":
                                    //System.out.println("私聊消息");
                                    System.out.print("请输入想聊天的用户号(在线)：");
                                    String getterId = Utility.readString(50);
                                    while(true) {
                                        System.out.print("请输入想说的话(输入q退出)：");
                                        String content = Utility.readString(100);
                                        if(content.equals("q")){
                                            break;
                                        }
                                        //编写一个方法，将消息发送给服务端
                                        messageClientService.sendMessageToOne(content, userId, getterId);
                                    }
                                    break;
                                case "4":
                                    System.out.print("请输入你想把文件发送给的用户(在线用户)：");
                                    getterId = Utility.readString(50);
                                    System.out.print("请输入发送文件的路径(形式 e:\\xx.jpg)：");
                                    String src = Utility.readString(100);
                                    System.out.print("请输入要发送文件的目的地路径(形式 e:\\yy.jpg)：");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else{
                        System.out.println("============登陆失败===========");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
