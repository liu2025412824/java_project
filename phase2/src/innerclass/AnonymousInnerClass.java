package innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04{
    private int n1 = 10; //属性
    public void method(){ //方法
        //基于接口的匿名内部类
//老方法
//        Tiger t = new Tiger();
//        t.cry();
        //匿名内部类
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎在嚎叫...");
            }
        };
        tiger.cry();

        //基于类的匿名内部类
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法 n1="+n1);
            }
        };
        System.out.println("father对象的运行类型="+father.getClass());
        father.test();

        //直接调用
        new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("hello");

    }
}

interface IA{
    public void cry();
}

//class Tiger implements IA{
//    public void cry(){
//        System.out.println("老虎在嚎叫...");
//    }
//}

class Father{

    public Father(String name) {
    }
    public void test(){
    }
    public void ok(String str){
        System.out.println(str+"Father ok");
    }
}