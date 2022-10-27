package com.encap;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Scanner;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        person.setAge(43);
        person.setSalary(3000);
        person.info();  //获取全部信息
        //System.out.println("salary:"+person.getSalary());  //获取工资

        System.out.println("smith的信息:");
        Person smith = new Person("smith", 22, 5000);
        smith.info();
    }
}

class Person{
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() >=2 && name.length() <=6) {
            this.name = name;
        }else {
            System.out.println("name的长度应设置在2-6个字符之间，已默认设为\"无名\"");
            this.name = "无名";
        }
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age >=1 && age <=120 ) {
            this.age = age;
        }else {
            System.out.printf("年龄设置不合理，应在1-120，已默认设为18");
            this.age = 18;
        }
    }

    public Double getSalary() {
        while(true){
            System.out.println("请输入管理员密码:");
            Scanner input = new Scanner(System.in);
            String passwd = input.next();
            if(passwd.equals("123")) {
                return salary;
            }else if(passwd.charAt(0) == 'q'){
                return null;
            }else {
                System.out.println("密码错误，请重新输入:<退出请输q>");
            }
        }
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void info(){
        System.out.println("信息为: name:"+name+" age:"+age+" salary:"+salary);
    }
}
