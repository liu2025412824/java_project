package interface_.interface01;

//Phone类实现UsbInterface
//即Phone 类 需要实现 UsbInterface接口 规定/声明的方法
public class Phone implements UsbInterface{
    public void start(){
        System.out.println("手机开始工作了...");
    }
    public void stop(){
        System.out.println("手机停止工作了...");
    }
}
