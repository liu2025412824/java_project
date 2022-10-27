package tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Lzy
 * @version 1.0
 */
public class LzyTankGame01 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        LzyTankGame01 lzyTankGame01 = new LzyTankGame01();
    }

    public LzyTankGame01(){
        System.out.println("请输入选择：1.新游戏  2.继续上局");
        String key = input.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //再JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
