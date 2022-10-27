package innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        //外部其他类 使用静态内部类
        //方式一：
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        //方式二：
        Outer10.Inner10 inner101 = outer10.getInner10();
        inner101.say();

        //方式二(静态的get方法)
        Outer10.Inner10 inner102 = Outer10.getInner10_();
        inner102.say();
    }
}

class Outer10{ //外部类
    private int n1 =10;
    private static String name = "张三";
    private static void cry(){}
    static class Inner10{
        private String name = "李四";
        public void say(){
            System.out.println("外部类name="+Outer10.name+" 内部类name="+name);
            cry();
        }
    }

    public void m1(){ //外部类使用静态内部类，创建一个对象放在一个方法里访问就行
        Inner10 inner10 = new Inner10();
        inner10.say();
    }
    public Inner10 getInner10(){
        return new Inner10();
    }
    public static Inner10 getInner10_(){
        return new Inner10();
    }
}
