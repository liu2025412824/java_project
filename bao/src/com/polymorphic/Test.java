package com.polymorphic;

public class Test {
    public static void main(String[] args) {

        Master master = new Master("汤姆");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        master.feed(dog,bone);

        Cat cat = new Cat("阿花");
        Fish fish = new Fish("草鱼");
        master.feed(cat,fish);
    }
}
