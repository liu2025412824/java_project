package map_;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {

        Map hashMap = new HashMap();
        hashMap.put(1,new Employee("jack",300000,1));
        hashMap.put(2,new Employee("tom",200000,2));
        hashMap.put(3,new Employee("smith",5000,3));

        Set keyset = hashMap.keySet();
        for(Object key:keyset){
            Employee e = (Employee)hashMap.get(key);
            if(e.getSal() > 18000){
                System.out.println(e);
            }
        }
        System.out.println();

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Employee e = (Employee)entry.getValue();
            if(e.getSal() > 18000){
                System.out.println(e);
            }
        }
    }
}

class Employee{
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return name+" "+sal+" "+id;
    }

}