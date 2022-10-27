package interface_.interface01;

//Camera类实现UsbInterface
//即Camera 类 需要实现 UsbInterface接口 规定/声明的方法
public class Camera implements UsbInterface{ //实现接口
    public void start(){
        System.out.println("相机开始工作了...");
    }
    public void stop(){
        System.out.println("相机停止工作了...");
    }
}
