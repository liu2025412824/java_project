package file.ObjectIOStream_;

import file.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * @author Lzy
 * @version 1.0
 */
public class ObjectIntputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String filePath = "e:\\javafiletest\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型="+dog.getClass());
        System.out.println("dog信息="+dog);//底层Object -> Dog

        //注意：写完代码后，一定要把写入序列化文件的代码再重新运行一遍！
        //因为写入的文件中包含一个默认的Dog类的包位置，当Dog类的位置有改动时，需要重新写入一下序列化
        //否则读取序列化时包名位置不符，抛异常

        Dog dog2 = (Dog)dog;

        //关闭流
        ois.close();
    }
}
