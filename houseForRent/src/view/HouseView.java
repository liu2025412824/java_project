package view;

import domain.House;
import service.HouseService;
import utils.Utility;

import javax.rmi.CORBA.Util;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(2); //设置数组大小为10

    public void listHouse(){
        System.out.println("==============================房屋列表===========================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();  //得到所有房屋信息
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("=================================================================");
    }

    public void addHouse(){
        System.out.println("添加房屋... ...");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        //创建一个新的House对象，id是系统给分配的，用户不能输入
        House newHouse = new House(0,name,phone,address,rent,state);
        if(houseService.add(newHouse)){
            System.out.println("添加房屋成功... ...");
        }
    }

    public void delHouse(){
        System.out.println("删除房屋... ...");
        System.out.println("请输入要删除的房屋id(-1退出）：");
        int delId = Utility.readInt();
        if(delId == -1){
            System.out.println("放弃删除房屋信息...");
            return;
        }
        //注意该方法本身就有循环判断逻辑,必须输出Y/N
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(delId)){
                System.out.println("删除房屋信息成功...");
            }else{
                System.out.println("未找到该房屋信息...");
            }
        }else{
            System.out.println("放弃删除房屋信息...");
        }
    }

    public void findHouse1(){
        System.out.print("请输入要查找的房屋地区:");
        String findAddress = Utility.readString(16);
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses =houseService.find(findAddress);
        int flag = -1;
        for (int i = 0; i < houses.length; i++) {
            if (findAddress.equals(houses[i].getAddress())) {
                flag = 1;
                System.out.println(houses[i]);
                //break;
            }
            if(houses[i] == null){
                break;
            }
        }
        if(flag == -1){
            System.out.println("未找到该房屋信息...");
        }
    }
    public void findHouse2(){
        System.out.print("请输入要查找的房屋id:");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if(house != null){
            System.out.println(house);
        }else{
            System.out.println("未找到该房屋信息...");
        }
    }

    public void updateHouse(){
        System.out.println("修改房屋信息");
        System.out.print("请选择待修改房屋的编号(-1表示退出):");
        int findId = Utility.readInt();
        if(findId == -1){
            System.out.println("放弃修改...");
            return;
        }
        House house = houseService.findById(findId);
        if(house == null){
            System.out.println("未找到该房屋信息...");
        }
        System.out.println("姓名("+house.getName()+")：");
        String name = Utility.readString(8,"");//这里表示如果用户直接回车表示不修改信息
        if(!"".equals(name)){
            house.setName(name);
        }
        System.out.println("电话("+house.getPhone()+")：");
        String phone = Utility.readString(12,"");//这里表示如果用户直接回车表示不修改信息
        if(!"".equals(phone)){
            house.setPhone(phone);
        }
        System.out.println("地址("+house.getAddress()+")：");
        String adress = Utility.readString(16,"");//这里表示如果用户直接回车表示不修改信息
        if(!"".equals(adress)){
            house.setName(adress);
        }
        System.out.println("月租("+house.getRent()+")：");
        int rent = Utility.readInt(-1);
        if(rent != -1){
            house.setRent(rent);
        }
        System.out.println("状态("+house.getState()+")：");
        String state = Utility.readString(8,"");//这里表示如果用户直接回车表示不修改信息
        if(!"".equals(state)){
            house.setState(state);
        }
        System.out.println("修改房屋信息成功！");
    }

    public void exit(){
        System.out.println("正在退出房屋出租系统...");
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            loop = false;
        }
    }

    //显示主菜单
    public void mainMenu(){

        do{
            System.out.println("==================房屋出租系统菜单=================");
            System.out.println("\t\t\t1.新增房源");
            System.out.println("\t\t\t2.查找房屋");
            System.out.println("\t\t\t3.修改房屋信息");
            System.out.println("\t\t\t4.删除房屋信息");
            System.out.println("\t\t\t5.房屋列表");
            System.out.println("\t\t\t6.退   出");
            System.out.print("请选择<1-6> :");
            key= Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    //findHouse1();
                    findHouse2();
                    break;
                case '3':
                    updateHouse();
                    break;
                case '4':
                    delHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while(loop);
    }
}
