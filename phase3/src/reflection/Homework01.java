package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Lzy
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws Exception {

        //Class privateTest1 = Class.forName("reflection.PrivateTest");
        Class privateTestClass = PrivateTest.class;
        Object o = privateTestClass.newInstance();
        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"李建国");
        Method method = privateTestClass.getMethod("getName");
        System.out.println("name="+method.invoke(o));

    }
}

class PrivateTest{
    private String name = "hellokity";
    public String getName(){
        return name;
    }
}