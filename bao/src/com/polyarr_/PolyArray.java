package com.polyarr_;

public class PolyArray {
    public static void main(String[] args) {

        Person[] person = new Person[5];
        person[0] = new Person("张三",23);
        person[1] = new Student("李四",17,97.5);
        person[2] = new Student("王五",18,93.5);
        person[3] = new Teacher("李六",34,20000);
        person[4] = new Teacher("刘七",38,25000);

        //循环遍历多态数组,调用say
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say()); //动态绑定机制
            //使用 类型判断+向下转型
            if(person[i] instanceof Student){
                ((Student)person[i]).study();
            }
            if(person[i] instanceof Teacher){
                ((Teacher)person[i]).teach();
            }
        }
    }

}
