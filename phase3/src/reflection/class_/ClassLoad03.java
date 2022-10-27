package reflection.class_;

/**
 * @author Lzy
 * @version 1.0
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        //1.加载B类，并生成B的class对象
        //2.链接 num = 0
        //3.初始化阶段
        //    依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句
        /*
                clinit{
                    System.out.println("B 静态代码块被执行");
                    //num = 300;
                    num = 100;
                }
                合并：num = 100;
        * */

    }
}

class B{
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B(){
        System.out.println("B() 构造器被执行");
    }
}
