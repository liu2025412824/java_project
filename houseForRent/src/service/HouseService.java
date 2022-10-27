package service;

import domain.House;

public class HouseService {
    private House[] houses;
    private int houseNum = 1;
    private int idCounter = 1;

    public HouseService(int size){
        houses = new House[size];
        houses[0] = new House(1,"张三","113","经开区",1500,"未出租");
    }

    public House[] list(){
        return houses;
    }

    public boolean add(House newHouse){
        if(houses.length == houseNum){
            //System.out.println("数组已经满了,不能再添加了...");
            //return false;
            //扩容一下
            House[] houses2 = new House[houses.length+5];
            for (int i = 0; i < houses.length; i++) {
                houses2[i] = houses[i];
            }
            houses = houses2;
            System.out.println("数组扩容成功...");
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId){
        //找到要删除的房屋信息对应的下标(注：下标和房屋的编号不是一回事)
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if(delId == houses[i].getId()){
                index = i;
            }
        }

        if(index == -1){
            return false;
        }
        //找到该房屋信息，实行删除的模块:
        for (int i = index; i < houseNum-1; i++) {
            houses[i] = houses[i+1];
        }
        houses[houseNum-1] = null;
        houseNum--;
        return true;
    }

    public House[] find(String findAddress){
        return houses;
    }
    public House findById(int findId){
        for (int i = 0; i < houseNum; i++) {
            if(findId == houses[i].getId())
                return houses[i];
        }
        return null;
    }

}
