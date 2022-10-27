package com.lzy;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public void m1(){
        System.out.println(n1);
    }
}

class B{
    public void m2(){
        A a = new A();
        System.out.println(a.n3);
    }
}
