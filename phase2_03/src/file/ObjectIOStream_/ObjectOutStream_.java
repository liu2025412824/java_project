package file.ObjectIOStream_;

import file.Dog;

import java.io.*;

/**
 * @author Lzy
 * @version 1.0
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\javafiletest\\data.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.5);
        oos.writeUTF("你好小同志");
        //保存一个Dog对象
        oos.writeObject(new Dog("旺财",10));

        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}
