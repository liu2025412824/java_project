package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @author Lzy
 * @version 1.0
 * 坦克大战的绘图区域
 */
//为了监听 键盘事件，实现KeyListener
//为了让Panel不停的重绘子弹，需要将Mypanel做成线程，实现Runnable，当一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    //定义一个我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector,用于恢复敌人坦克的坐标方向
    Vector<Node> nodes = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //说明，当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 9;

    //定义三张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key){
        //先判断记录的文件是否存在
        //如果存在，就正常执行，如果文件不存在，提示：只能开启新游戏，key="1"
        File file = new File(Recorder.getRecordFile());
        if(file.exists()){
            nodes = Recorder.getNodesAndEnemyTankRec();
        }else{
            System.out.println("文件不存在，只能开启新的游戏");
            key = "1";
        }
        //将MyPanel对象的enemyTanks设置给Recorder的enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        hero = new Hero(100,600);//初始化自己的坦克
        hero.setSpeed(2);
        switch (key){
            case "1":
                //初始化敌人坦克
                for (int i = 0;i<enemyTankSize;i++){
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank(100*(1+i),0);
                    //将enemyTank设置给enemyTank！！！
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(2);
                    //启动敌人坦克线程，让它动起来
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                //初始化敌人坦克
                for (int i = 0;i<nodes.size();i++){
                    Node node = nodes.get(i);
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY());
                    //将enemyTank设置给enemyTank！！！
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(node.getDirect());
                    //启动敌人坦克线程，让它动起来
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.print("你的输入有误");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));
    }

    public void showInfo(Graphics g){
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);

        g.drawString("您累积击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);//画出一个敌方坦克
        g.setColor(Color.BLACK);//这里需要重新设置成黑色
        g.drawString(Recorder.getAllEnemyTankNUm()+"",1080,100);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色

        if(hero != null && hero.isLive) {
            //画出自己坦克-封装到方法
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }

//        //画出hero设计的子弹
//        if(hero.shot != null && hero.shot.isLive == true){
//            //System.out.println("子弹被绘制...");
//            g.draw3DRect(hero.shot.x,hero.shot.y,1,1,false);
//        }
        //画出hero的子弹集合
        for(int i=0;i < hero.shots.size();i++){
            Shot shot = hero.shots.get(i);
            if(shot != null && shot.isLive == true){
                g.draw3DRect(shot.x,shot.y,1,1,false);
            }else{
                hero.shots.remove(shot);
            }
        }

        //如果bombs集合中有对象，就画出
        for(int i=0;i< bombs.size();i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if(bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life > 3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让这个炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life为0，就从bombs的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }

        //画出敌人坦克
        for(int i = 0;i<enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
             //判断敌人坦克是否存活
            if(enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出enemyTank所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        //从Vector移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }

    //编写方法，画出坦克
    public void drawTank(int x,int y,Graphics g,int direct,int type){

        //根据不同类型的坦克，设置不同颜色
        switch(type){
            case 0://敌方坦克
                g.setColor(Color.cyan);
                break;
            case 1://我方坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        switch(direct){
            case 0://表示向上
                g.fill3DRect(x,y,10,60,false);//画出坦克左边轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克盖子
                g.drawOval(x+10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y);//画出炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x,y,60,10,false);//画出坦克左边轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克右边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克盖子
                g.drawOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x+60,y+20);//画出炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边轮子
                g.fill3DRect(x+30,y,10,60,false);//画出坦克右边轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出坦克盖子
                g.drawOval(x+10,y+20,20,20);//画出圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);//画出炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x,y,60,10,false);//画出坦克左边轮子
                g.fill3DRect(x,y+30,60,10,false);//画出坦克右边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出坦克盖子
                g.drawOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x ,y+20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
    //编写方法，判断我方的子弹是否击中敌方坦克
    //什么时候判断我方的子弹是否击中敌人的坦克？run方法中
    //后面我们将enemyTank 改为 tank
    public void hitTank(Shot s,Tank enemyTank){
        switch(enemyTank.getDirect()){
            case 0://坦克向上
            case 2://坦克向下
                if(s.x >= enemyTank.getX() &&s.x <= enemyTank.getX()+40 &&
                        s.y >= enemyTank.getY() && s.y <= enemyTank.getY()+60){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人坦克后，将enemyTank从Vector拿掉(否则打空气也会爆炸)
                    enemyTanks.remove(enemyTank);
                    //当我方击毁一个敌方坦克后，就对数据allEnemyTankNum++
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if(s.x >= enemyTank.getX() && s.x <= enemyTank.getX()+60 &&
                        s.y >= enemyTank.getY() && s.y <= enemyTank.getY()+40){
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人坦克后，将enemyTank从Vector拿掉(否则打空气也会爆炸)
                    enemyTanks.remove(enemyTank);
                    //当我方击毁一个敌方坦克后，就对数据allEnemyTankNum++
                    if(enemyTank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;

        }
    }
    //如果我们的坦克可以发射多个子弹，在判断我方坦克是否击中敌人坦克时，
    //就需要把我们的子弹集合中所有的子弹都取出和敌人的所有坦克，进行判断。
    public void hitEnemyTank(){
        for(int i=0;i < hero.shots.size();i++){
            Shot shot = hero.shots.get(i);
            //判断是否击中了敌人的坦克
            if(shot != null && shot.isLive){//当子弹还存活
                //遍历敌人所有坦克
                for(int j=0;j<enemyTanks.size();j++){
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot,enemyTank);
                }
            }
        }
    }
    //编写方法，判断敌人坦克是否击中我的坦克
    public void hitHero(){
        //遍历所有的敌人坦克
        for(int i=0;i<enemyTanks.size();i++){
            //取出敌人坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历enemyTank对象的所有子弹
            for(int j=0;j<enemyTank.shots.size();j++){
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我的坦克
                    if(hero.isLive && shot.isLive){
                        hitTank(shot,hero);
                    }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            if(hero.getY() > 0) {
                hero.moveUp();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            if(hero.getX()+60 < 1000) {
                hero.moveRight();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            if(hero.getY()+60 < 750) {
                hero.moveDown();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            if(hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //如果用户按下的是J，就发射
        if(e.getKeyCode() == KeyEvent.VK_J){
            //System.out.println("用户按下了J，开始射击...");
//            //判断hero的子弹是否消亡(只能发射一颗子弹)
//            if(hero.shot == null || hero.shot.isLive == false) {
//                hero.shotEnemyTank();
//            }
            //发射多颗子弹
            hero.shotEnemyTank();
        }

        //让画板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔100毫秒，重绘区域，刷新绘图区域，子弹就移动
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            //判断我们的子弹是否击中了敌人的坦克(只能判断一发子弹版本)
//            if(hero.shot != null && hero.shot.isLive){//当我的子弹还存活
//                //遍历敌人所有坦克
//                for(int i=0;i<enemyTanks.size();i++){
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(hero.shot,enemyTank);
//                }
//            }

            hitEnemyTank();//判断我们的子弹集合是否击中敌人坦克(判断多发子弹)
            hitHero();//判断敌人坦克是否击中了我们
            this.repaint();
        }
    }
}
