package com.object_;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class ToString_ {
    public static void main(String[] args) {
        Monster m1 = new Monster("张三","焊工",3000);
        System.out.println(m1.toString() +" hashcode="+m1.hashCode());
        System.out.println(m1);
    }

}

class Monster{
    private String name;
    private String job;
    private double sal;

    public Monster(String name, String job, double sal) {
        this.name = name;
        this.job = job;
        this.sal = sal;
    }

    //重写toString方法，输出对象的属性
    //使用快捷键即可
    @Override
    public String toString() {  //重写后一般是把对象的属性值输出，当然程序员也可以自己制定
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
