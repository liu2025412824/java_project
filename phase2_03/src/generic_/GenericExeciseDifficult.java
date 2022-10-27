package generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExeciseDifficult {
    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("tom",2000,new MyDate(2002,9,8)));
        list.add(new Employee("jack",3000,new MyDate(2003,11,8)));
        list.add(new Employee("tom",5000,new MyDate(2001,10,8)));

        System.out.println(list);

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if(!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("类型不正确...");
                    return 0;
                }
                //比较name
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0){
                    return i;
                }
                //对birthday的比较放在MyDate类中完成
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println(list);
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
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
    public MyDate getBirthday() {
        return birthday;
    }
    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year +"-"+ month+"-"+ day;
    }
    //重写了compareTo方法，Comparable接口已经指定了MyDate的泛型，所以此处也必须为MyDate
    public int compareTo(MyDate o){
        int y = year - o.getYear();
        if(y != 0){
            return y;
        }
        int m = month - o.getMonth();
        if(m != 0){
            return m;
        }
        int d = day - o.getDay();
        return d;
    }
}
