package reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Lzy
 * @version 1.0
 */
public class Reflectionquestion {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\reflection\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String methodName1 = properties.getProperty("method1");
        String methodName2 = properties.getProperty("method2");

        Class cls = Class.forName(classfullpath);

        Object o = cls.newInstance();
        System.out.println("o的运行类型"+o.getClass());

        Method method1 = cls.getMethod(methodName1);
        Method method2 = cls.getMethod(methodName2);

        method1.invoke(o);
        method2.invoke(o);

        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o));
    }
}
