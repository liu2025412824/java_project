package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象，可以当作线程使用
        Cat cat = new Cat();
        cat.start();//启动线程 ->最终会执行cat的run方法

        System.out.println("主程序继续执行"+Thread.currentThread().getName());
        for(int i=0;i<60;i++){
            System.out.println("主进程i="+i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread{
    int count=0;
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("喵喵，我是小猫咪"+(++count)+" "+Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 80){
                break;
            }
        }
    }
}