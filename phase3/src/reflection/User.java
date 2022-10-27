package reflection;

/**
 * @author Lzy
 * @version 1.0
 */
public class User {
    private int age = 10;
    private String name = "韩顺平教育";

    public User(){ //无参
    }
    public User(String name){ //public有参构造器
        this.name = name;
    }
    private User(int age,String name){ //private有参构造器
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
