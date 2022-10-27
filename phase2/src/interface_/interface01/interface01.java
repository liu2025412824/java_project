package interface_.interface01;

public class interface01 {
    public static void main(String[] args) {
        //创建手机，相机对象
        Phone phone = new Phone();
        Camera camera = new Camera();
        //创建计算机
        Computer computer = new Computer();
        computer.work(phone);
        computer.work(camera);
    }
}
