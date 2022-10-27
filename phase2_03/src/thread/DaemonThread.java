package thread;

/**
 * @author Lzy
 * @version 1.0
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        MyDaemonThread md = new MyDaemonThread();
        md.setDaemon(true);
        md.start();
        for(int i =0;i<10;i++){
            System.out.println("宝强在辛苦的工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆在一起快乐的聊天~");
        }
    }
}
