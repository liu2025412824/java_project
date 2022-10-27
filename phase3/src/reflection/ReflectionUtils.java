package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Lzy
 * @version 1.0
 */
public class ReflectionUtils {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> personCls = Class.forName("reflection.Person");
        System.out.println(personCls.getName());
        System.out.println(personCls.getSimpleName());
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method[] DelcaredMethods = personCls.getDeclaredMethods();
        for (Method delcaredMethod : DelcaredMethods) {
            System.out.println(delcaredMethod.getName());
        }
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
    }
}

class A{
    public String sender;
    private String day;
    public void m5(){
    }
    private void m6(){
    }
}

class Person extends A{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person(){
    }
    //方法
    public void m1(){
    }
    protected void m2(){
    }
    void m3(){
    }
    private void m4(){
    }
}
