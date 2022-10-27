package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {

        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.setName("老刘");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();

        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            System.out.println("hi "+i);
        }

        System.out.println(thread.getName()+" 线程的优先级为="+ thread.getPriority());
        thread.interrupt();
    }
}

class T1 implements Runnable{
    @Override
    public void run() {
        while(true){
            for(int i = 0;i<20;i++){
                System.out.println(Thread.currentThread().getName()+" 吃包子~ "+i);
            }

            try{
                System.out.println(Thread.currentThread().getName()+" 休眠中...");
                Thread.sleep(20000);
            }catch(InterruptedException e){
                //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException 是捕获到一个中断异常
                System.out.println(Thread.currentThread().getName()+" 被interrup 中止休眠了");
            }
        }
    }
}
