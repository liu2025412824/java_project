package generic_;

import java.util.*;

public class GenericExercise {
    public static void main(String[] args) {

        HashSet<Student> hst = new HashSet<Student>();
        hst.add(new Student("tom",23));
        hst.add(new Student("jack",22));
        hst.add(new Student("smith",24));

        for(Student s :hst){
            System.out.println(s);
        }

        HashMap<String, Student> hmp = new HashMap<String,Student>();
        hmp.put("tom",new Student("tom",23));
        hmp.put("jack",new Student("jack",22));
        hmp.put("smith",new Student("smith",24));
        Set<Map.Entry<String,Student>> entries = hmp.entrySet();
        Iterator<Map.Entry<String,Student>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Student> next = iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }

        for(Map.Entry<String,Student> n:entries){
            System.out.println(n.getKey()+" "+n.getValue());
        }

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
