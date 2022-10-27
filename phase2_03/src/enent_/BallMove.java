package enent_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Lzy
 * @version 1.0
 */
public class BallMove extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.addKeyListener(mp);//窗口JFrame对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y+=5;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y-=5;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x-=5;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=5;
        }

        this.repaint();//让面板重绘；
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
