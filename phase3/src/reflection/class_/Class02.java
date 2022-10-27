package reflection.class_;

import reflection.Car;

import java.lang.reflect.Field;

/**
 * @author Lzy
 * @version 1.0
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classAllPath = "reflection.Car";
        Class<?> cls = Class.forName(classAllPath);

        System.out.println(cls);//显示cls对象
        System.out.println(cls.getClass());//运行类型
        System.out.println(cls.getPackage().getName());//包名
        System.out.println(cls.getName());//全包名

        Car car = (Car)cls.newInstance();
        System.out.println(car);

        Field brand = cls.getField("brand");
        //System.out.println(brand); //brand属性的详细信息
        System.out.println(brand.get(car));

        brand.set(car,"奔驰");
        System.out.println(brand.get(car));

        System.out.println("===========所有的字段属性=========");
        Field[] fields = cls.getFields();
        for(Field f:fields){
            System.out.print(f.getName()+" ");
            System.out.print(f.get(car));
            System.out.println();
        }
    }
}
