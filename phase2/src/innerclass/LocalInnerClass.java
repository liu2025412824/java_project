package innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode="+outer02.hashCode());
    }
}

class Outer02{ //外部类
    private int n1 = 100;
    private void m2(){
        System.out.println("Outer02 m2()被调用");
        //Inner02 inner02 = new Inner02();已经不在内部类的作用域了！错误!
    };
    public void m1(){
        final class Inner02{
            private int n1 = 800;
            public void f1(){
                System.out.println("外部类的n1="+Outer02.this.n1);
                //Outer02.this的本质就是外部类的对象，即那个对象调用了m1，Outer02.this就是哪个对象
                System.out.println("Outer02.this的hashcode="+Outer02.this.hashCode());
                System.out.println("内部类的n1="+n1);
                m2();
            }
        }

        Inner02 inner02 = new Inner02();
        inner02.f1();

    }
}
