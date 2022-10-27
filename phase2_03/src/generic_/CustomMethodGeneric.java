package generic_;

import java.util.ArrayList;

public class CustomMethodGeneric {
    public static void main(String[] args){

        Car car = new Car();
        car.fly("hello",34);
        car.fly(24,3.14);

        //T->String , R->ArrayList
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(),3.14f);
    }
}

class Car{ //普通类
    public void run(){} //普通方法

    public <T,R> void fly(T t,R r){ //泛型方法
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class Fish<T,R>{ //泛型类
    public void run(){} //普通方法
    public <U,M> void eat(U u,M m){ //泛型方法

    }

    public void hi(T t){ //hi方法使用了类声明的泛型，而hi方法不是泛型方法
    }

    public<K> void hello(R r,K k){
        System.out.println(r.getClass()); //ArrayList
        System.out.println(k.getClass()); //Float
    }
}
