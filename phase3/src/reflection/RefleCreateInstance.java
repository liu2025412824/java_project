package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Lzy
 * @version 1.0
 */
public class RefleCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> userClass = Class.forName("reflection.User");
        Object o1 = userClass.newInstance();
        System.out.println(o1);

        Constructor<?> constructor1 = userClass.getConstructor(String.class);
        Object o2 = constructor1.newInstance("张三");
        System.out.println(o2);

        Constructor<?> constructor2 = userClass.getDeclaredConstructor(int.class,String.class);
        constructor2.setAccessible(true);//暴力破解
        Object o3 = constructor2.newInstance(70,"李四");
        System.out.println(o3);
    }
}
