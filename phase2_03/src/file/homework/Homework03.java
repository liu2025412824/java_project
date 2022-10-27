package file.homework;

import java.io.*;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {

        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        //properties.list(System.out);
        String name = properties.get("name")+"";//Object -> String (也可以直接用getProperty)
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name,age,color);
        System.out.println("==========dog对象信息==========");
        System.out.println(dog);

        //将创建的Dog对象，序列化到文件 dog.dat 中
        String serFilePath = "e:\\javafiletest\\dog.dat";
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);

        oos.close();
        System.out.println("dog对象，序列化完成...");

        //反序列化
        try {
            Homework03.m1();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "e:\\javafiletest\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)ois.readObject();//需要把读取到的内容转换一下类型(即使不向下转型，由于动态绑定也可以执行)

        ois.close();
        System.out.println("=============反序列化后 dog=============");
        System.out.println(dog);
    }
}

class Dog implements Serializable {
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
