package reflection;

import java.lang.reflect.Method;

/**
 * @author Lzy
 * @version 1.0
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws Exception {

        Class cls = Class.forName("reflection.Boss");
        Object o = cls.newInstance();
        Method say = cls.getDeclaredMethod("say",int.class,String.class,char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o,100,"王五",'男'));
        System.out.println(say.invoke(null,200,"李四",'女'));

    }
}

class Boss{
    public String name;
    private static int age;

    private static String say(int n,String name,char sender){
        return n+" "+name+" "+sender;
    }
}