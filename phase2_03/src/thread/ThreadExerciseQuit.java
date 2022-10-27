package thread;

import java.util.Scanner;

/**
 * @author Lzy
 * @version 1.0
 */
public class ThreadExerciseQuit {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread{
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        //输出1-100数字
        while(loop){
            System.out.println((int)(Math.random()*100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a进程退出...");
    }
}

class B extends Thread{
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("输入指令 Q 退出");
            char res = input.next().toUpperCase().charAt(0);
            if(res == 'Q'){
                a.setLoop(false);
                System.out.println("b进程退出...");
                break;
            }
        }
    }
}