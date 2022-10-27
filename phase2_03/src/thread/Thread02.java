package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class Thread02 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

//        ThreadProxy threadProxy = new ThreadProxy(dog);
//        threadProxy.start();

        System.out.println("hello");
    }
}

//线程代理类，模拟了一个极简的Thread类
class ThreadProxy implements Runnable{

    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if(target != null){
            target.run();//动态绑定(运行类型Dog)
        }
    }

    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
}

class Dog implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("王晓宇是个derb "+(++times)+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 8){
                break;
            }
        }
    }
}
