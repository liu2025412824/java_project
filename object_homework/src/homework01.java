public class homework01 {
    public static void main(String[] args) {
        Person[] persons = new Person[3]; //创建对象数组
        persons[0] = new Person("张三",23,"厨子");
        persons[1] = new Person("李四",46,"戏子");
        persons[2] = new Person("王五",21,"痞子");

        Person tmp = null;
        for (int i = 0; i < persons.length-1; i++) {
            for(int j=0;j<persons.length-1-i;j++){
                if(persons[j].getAge() > persons[j+1].getAge()){
                    tmp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

    }
}

class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
