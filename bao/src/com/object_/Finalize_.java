package com.object_;

public class Finalize_ {
    public static void main(String[] args) {
        Car bmw = new Car("宝马");
        bmw = null;
        System.gc();
        System.out.println("程序退出了...");
    }
}

class Car{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("汽车被销毁了...");
        System.out.println("释放了某些资源...");
    }
}