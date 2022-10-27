package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class ThreadExerciseWithdrawal {
    public static void main(String[] args) {
        W w = new W();  //这里只创建了一个对象，启动了两个线程而已;
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class W implements Runnable{
private static int money = 10000;
private static Object object = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (object) {
                if (money < 1000) {
                    System.out.println("余额不足！");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() +
                        "窗口成功取出1000元... 剩余余额：" + money + "元");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}