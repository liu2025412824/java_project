package thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lzy
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        Thread.sleep(5000);
        t.setLoop(false);
    }
}

class T extends Thread{
    private int count = 0;
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            try{
                Thread.sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("T 运行中..."+(++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
