package generic_;

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {

        ArrayList<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("旺财",5));
        list.add(new Dog("晓宇",3));
        list.add(new Dog("大黄",7));

        //list.add(new Cat());

        for(Dog dog:list){
            System.out.println(dog.getName()+" "+dog.getAge());
        }
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
}

class Cat{

}
