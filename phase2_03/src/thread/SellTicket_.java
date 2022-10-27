package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class SellTicket_ {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();

        //使用实现接口的方式来售票
//        SellTicket02 sel = new SellTicket02();
//        new Thread(sel).start();
//        new Thread(sel).start();
//        new Thread(sel).start();

        //同步后的买票
//        SellTicket03 sel = new SellTicket03();
//        new Thread(sel).start();
//        new Thread(sel).start();
//        new Thread(sel).start();

    }
}

class SellTicket01 extends Thread{
    private static int tickets = 100;
    static Object o = new Object();  //保证多线程，共享一个对象，这里使用static

    @Override
    public void run() {
        while (true) {
            synchronized (o) {
                if (tickets <= 0) {
                    System.out.println("售票结束...");
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("窗口 " + Thread.currentThread().getName() + " 售出了一张票"
                        + " 剩余票数=" + (--tickets));
            }
        }
    }
}

class SellTicket02 implements Runnable{
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if(tickets <= 0){
                System.out.println("售票结束...");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 "+Thread.currentThread().getName()+" 售出了一张票"
                    +" 剩余票数="+(--tickets));
        }
    }
}

class SellTicket03 implements Runnable{
    private static int tickets = 100;//让多个线程共享tickets
    private boolean loop = true;

    public synchronized void sell(){  //同步方法，在同一时刻，只能有一个线程来执行sell方法
        if(tickets <= 0){
            System.out.println("售票结束...");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("窗口 "+Thread.currentThread().getName()+" 售出了一张票"
                +" 剩余票数="+(--tickets));
    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
