package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lzy
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class fileCls = Class.forName("java.io.File");

        Constructor[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println("File构造器="+declaredConstructor);
        }

        String fileAllPath = "e:\\JavaFileTest\\ReflectionTest.txt";
        Constructor declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        Object file = declaredConstructor.newInstance(fileAllPath);

        Method creatNewFile = fileCls.getMethod("createNewFile");
        creatNewFile.invoke(file);

        System.out.println("创建文件成功"+fileAllPath);
    }
}
