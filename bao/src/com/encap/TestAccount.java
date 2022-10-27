package com.encap;

public class TestAccount {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.setName("张三");
        a1.setBalance(600);
        a1.setPwd("123456");

        a1.showInfo();
    }
}
