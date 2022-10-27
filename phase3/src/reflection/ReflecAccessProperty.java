package reflection;

import java.lang.reflect.Field;

/**
 * @author Lzy
 * @version 1.0
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("reflection.Student");
        Object o = c.newInstance();
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null,"张三");
        System.out.println(o);
        System.out.println(name.get(null));
    }
}

class Student{
    public int age;
    private static String name;

    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +",name="+name+
                '}';
    }
}