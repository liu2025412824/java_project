package static_;

public class StaticMethod {
    public static void main(String[] args) {

        Stu tom = new Stu("tom");
        tom.payFee(100);
        Stu mack = new Stu("mack");
        mack.payFee(200);

        Stu.payFee(500);
        Stu.show();
    }
}

class Stu{
    private String name;
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(int fee){
        Stu.fee += fee;
    }
    public static void show(){
        System.out.println("累计学费为"+fee);
    }
}