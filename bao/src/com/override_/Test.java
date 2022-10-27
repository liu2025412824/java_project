package com.override_;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("张三",22);
        System.out.println(p1.say());
        Student s1 = new Student("李四",23,"20013",78.5);
        System.out.println(s1.say());
    }
}
