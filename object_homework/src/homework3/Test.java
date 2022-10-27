package homework3;

public class Test {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Student("张三",'男',17,"20011");
        persons[1] = new Student("李四",'男',18,"20012");
        persons[2] = new Teacher("老王",'女',34,4);
        persons[3] = new Teacher("老刘",'女',36,6);

        Test t =new Test();
        t.pinformation(persons[0]);
        t.pinformation(persons[3]);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

    public void pinformation(Person p){
        if(p instanceof Student) {
            System.out.println("学生的信息：");
            System.out.println("姓名：" + p.getName());
            System.out.println("年龄：" + p.getAge());
            System.out.println("性别：" + p.getGender());
            System.out.println("学号：" + ((Student) p).getStu_id());
            System.out.println(((Student) p).study());
            System.out.println(p.play());
            System.out.println();
        }
        if(p instanceof Teacher){
            System.out.println("老师的信息：");
            System.out.println("姓名：" + p.getName());
            System.out.println("年龄：" + p.getAge());
            System.out.println("性别：" + p.getGender());
            System.out.println("学号：" + ((Teacher) p).getWork_age());
            System.out.println(((Teacher) p).teach());
            System.out.println(p.play());
        }
    }
}
