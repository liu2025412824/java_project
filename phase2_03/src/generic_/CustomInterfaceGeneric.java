package generic_;

public class CustomInterfaceGeneric {

    public static void main(String[] args) {

    }
}

interface IA extends Iusb<String,Integer>{}
class AA implements IA{

    @Override
    public Integer get(String s) {
        return null;
    }
    @Override
    public void hi(Integer integer) {

    }
    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}

class BB implements Iusb<String,Integer>{

    @Override
    public Integer get(String s) {
        return null;
    }
    @Override
    public void hi(Integer integer) {

    }
    @Override
    public void run(Integer r1, Integer r2, String u1, String u2) {

    }
}

class CC implements Iusb<Object,Object>{

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}

interface Iusb<U,R>{
    int n = 10;
    //U name;静态成员不能使用泛型

    R get(U u);
    void hi(R r);
    void run(R r1,R r2,U u1,U u2);
    //在jdk8中，可以在接口中，使用默认方法
    default R method(U u){
        return null;
    }
}
