package com.object_;

//自己重写类方法，判断Person类内容是否相等

public class Equals_exercise {
    public static void main(String[] args) {

        Person person1 = new Person("jack", 23, '男');
        Person person2 = new Person("jack", 23, '男');

        System.out.println(person1.equals(person2));
    }
}

class Person{ //extends Object
    private String name;
    private int age;
    private char gender;

    //重写Object的 equals方法
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;  //向下转型
            return this.name.equals(p.name) && this.age==p.age &&this.gender==p.gender;
        }
        return false;
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }


}