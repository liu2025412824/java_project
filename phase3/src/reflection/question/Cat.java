package reflection.question;

/**
 * @author Lzy
 * @version 1.0
 */
public class Cat {

    private String name = "喵了个喵";
    public int age = 10;
    public void hi(){
        System.out.println("hi "+name);
    }

    public void cry(){
        System.out.println(name+" 嘎嘎哭");
    }
}
