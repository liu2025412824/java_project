package static_;

public class ChildGame {
    public static void main(String[] args) {
        Child child1 = new Child("小明");
        child1.join();
        Child child2 = new Child("小张");
        child2.join();
        Child child3 = new Child("小王");
        child3.join();

        System.out.println("共有"+Child.count+"个小孩加入了游戏");
    }
}

class Child{
    private String name;
    public static int count =0;

    public Child(String name) {
        this.name = name;
    }
    public void join(){
        System.out.println(name+"加入了游戏...");
        count++;
    }
}
