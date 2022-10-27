package com.extend_computer;

public class PC extends Computer {
    private String brand;

    //IDEA根据继承规则自动把构造器调用写好
    //体现：继承设计的基本思想，父类构造器完成父类属性初始化
    //子类构造器完成子类属性初始化
    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println("PC信息为:");
        //调用父类的属性方法
        System.out.println(getDetails() + " brand:"+brand);
    }
}
