package single_;

public class singleTon01 {
    public static void main(String[] args) {
        Girlfriend red = Girlfriend.getInstance();
        System.out.println(red);

        Girlfriend red2 = Girlfriend.getInstance();
        System.out.println(red2);
    }
}

class Girlfriend{

    private String name;
    //为了能够再静态方法中，返回gf对象，需要将其修饰为static
    private static Girlfriend gf = new Girlfriend("小红");  //由下知必须定义为静态属性
    //如何保障我们只能创建一个Girlfriend对象
    //[单例模式--饿汉式]
    //1.将构造器私有化
    //2.在类的内部直接创建对象
    //3.提供一个公共的static方法，返回gf对象

    private Girlfriend(String name) {
        this.name = name;
    }

    public static Girlfriend getInstance(){  //必须为静态，否则无法通过类名调用
        return gf;    //静态方法中只能访问静态属性
    }

    @Override
    public String toString() {
        return "Girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
