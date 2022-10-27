package draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{ //JFrame对应窗口，可以理解成是一个画框

    private MyPanel mp = null;//定义一个面板
    public static void main(String[] args) {
        new DrawCircle();

    }

    public DrawCircle(){  //构造器
        mp = new MyPanel();//初始化面板
        this.add(mp); //把面板放入到窗口(画框)
        this.setSize(900,600);//设置窗口的大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当点击窗口的小×，程序完全退出
        this.setVisible(true);//可以显示
    }
}

//MyPanel 对象就是一个画板
//Graphics g 把g理解成一支画笔
//Graphics 提供了很多绘图的方法
class MyPanel extends JPanel{ //定义一个MyPanel继承JPanel类，画图形，就在面板上画
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("paint方法被调用了...");
        g.drawOval(10,10,100,100);//画一个圆形

//        Image img = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/111.jpg"));
//        g.drawImage(img,10,10,280,499,this);
        g.setColor(Color.red);
        g.setFont(new Font("楷书",Font.BOLD,50));
        g.drawString("北京你好",100,100);
    }
}
