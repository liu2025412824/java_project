package com.encap;

public class Account {
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.name = name;
        this.balance = balance;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.length() >=2 && name.length() <=4) {
            this.name =name;
        }else {
            System.out.println("姓名要求长度2位3位或4位,默认值为无名");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance >= 20) {
            this.balance = balance;
        }else {
            System.out.println("余额必须不少于20，默认值0.00");
            this.balance = balance;
        }
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        if(pwd.length() == 6) {
            this.pwd = pwd;
        }else {
            System.out.println("密码长度必须为六，默认值000000");
            this.pwd = pwd;
        }
    }

    public void showInfo(){
        System.out.println("姓名："+name+" 余额："+balance+" 密码："+pwd);
    }
}
