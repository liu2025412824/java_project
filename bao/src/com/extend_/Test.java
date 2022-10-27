package com.extend_;

public class Test {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "张三";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(96);
        pupil.showInfo();

        System.out.println("================================");
        Graduate graduate = new Graduate();
        graduate.name = "李四";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(69);
        graduate.showInfo();
    }
}