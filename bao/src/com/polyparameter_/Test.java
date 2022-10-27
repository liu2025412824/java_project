package com.polyparameter_;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class Test {
    public static void main(String[] args) {

        Employee worker = new Worker("小王",3000);
        Employee manager = new Manager("刘总",7000,100000);

        Test t = new Test();
        t.showEmpAnnual(worker);
        t.showEmpAnnual(manager);

        t.testWork(worker);
        t.testWork(manager);
    }

    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker)e).work();
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }else{
            System.out.println("不做动作");
        }
    }
}
