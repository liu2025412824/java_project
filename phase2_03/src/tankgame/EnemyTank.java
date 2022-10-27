package tankgame;

import java.util.Vector;

/**
 * @author Lzy
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable{
    //在敌人坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    //增加成员，EnemyTank 可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();

    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //这里提供一个方法，可以将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>()
    //设置到EnemyTank 的成员 enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断当前的这个敌人坦克，是否和enemyTanks中的其他坦克发生重叠或者碰撞
    public boolean isTouchEnemyTank(){
        switch(this.getDirect()){
            case 0://上
                //让当前敌人和坦克和其他所有敌人坦克比较
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank){
                        //如果敌人坦克是上/下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克的左上角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+40
                               && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                            //当前坦克的右上角坐标
                            if(this.getX()+40 >= enemyTank.getX() && this.getX()+40 <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if(enemyTank.getDirect() ==1 || enemyTank.getDirect() == 3){
                            //当前坦克的左上角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+60
                               && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                            //当前坦克的右上角坐标
                            if(this.getX()+40 >= enemyTank.getX() && this.getX()+40 <= enemyTank.getX()+60
                                    && this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://右
                //让当前敌人和坦克和其他所有敌人坦克比较
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank){
                        //如果敌人坦克是上/下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克的右上角坐标
                            if(this.getX()+60 >= enemyTank.getX() && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                            //当前坦克的右下角坐标
                            if(this.getX()+60 >= enemyTank.getX()+40 && this.getX()+60 <= enemyTank.getX()+40
                                    && this.getY()+40 >= enemyTank.getY() &&this.getY()+40 <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if(enemyTank.getDirect() ==1 || enemyTank.getDirect() == 3){
                            //当前坦克的右上角坐标
                            if(this.getX()+60 >= enemyTank.getX() && this.getX()+60 <= enemyTank.getX()+60
                                    && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                            //当前坦克的右下角坐标
                            if(this.getX()+60 >= enemyTank.getX() && this.getX()+60 <= enemyTank.getX()+60
                                    && this.getY()+40 >= enemyTank.getY() &&this.getY()+40 <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://下
                //让当前敌人和坦克和其他所有敌人坦克比较
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank){
                        //如果敌人坦克是上/下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克的左下角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+40
                                    && this.getY()+60 >= enemyTank.getY() &&this.getY()+60 <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                            //当前坦克的右下角坐标
                            if(this.getX()+40 >= enemyTank.getX() && this.getX()+40 <= enemyTank.getX()+40
                                    && this.getY()+60 >= enemyTank.getY() &&this.getY()+40 <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if(enemyTank.getDirect() ==1 || enemyTank.getDirect() == 3){
                            //当前坦克的左下角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+60
                                    && this.getY()+60 >= enemyTank.getY() &&this.getY()+60 <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                            //当前坦克的右下角坐标
                            if(this.getX()+40 >= enemyTank.getX() && this.getX()+40 <= enemyTank.getX()+60
                                    && this.getY()+60 >= enemyTank.getY() &&this.getY()+60 <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://左
                //让当前敌人和坦克和其他所有敌人坦克比较
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank){
                        //如果敌人坦克是上/下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //当前坦克的左上角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+40
                                    && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                            //当前坦克的左下角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+40
                                    && this.getY()+40 >= enemyTank.getY() &&this.getY()+40 <= enemyTank.getY()+60)
                            {
                                return true;
                            }
                        }
                        //如果敌人坦克是左/右
                        if(enemyTank.getDirect() ==1 || enemyTank.getDirect() == 3){
                            //当前坦克的左上角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+60
                                    && this.getY() >= enemyTank.getY() &&this.getY() <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                            //当前坦克的左下角坐标
                            if(this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX()+60
                                    && this.getY()+40 >= enemyTank.getY() &&this.getY()+40 <= enemyTank.getY()+40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public void run() {
        while(true){
            //这里判断如果shots size()<10，则创建一颗子弹，放入到shots集合，并且启动
            if(isLive && shots.size() < 10){
                Shot s = null;
                //判断坦克方向，创建对应的子弹
                switch(getDirect()){
                    case 0://上
                        s = new Shot(getX()+20,getY(),0);
                        break;
                    case 1://右
                        s = new Shot(getX()+60,getY()+20,1);
                        break;
                    case 2://下
                        s = new Shot(getX()+20,getY()+60,2);
                        break;
                    case 3://左
                        s = new Shot(getX(),getY()+20,3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }

            //根据坦克的方向来继续移动
            switch(getDirect()){
                case 0://向上
                    for(int i=0;i<30;i++) {
                        if(getY() > 0 && !isTouchEnemyTank()) {
                            moveUp1();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    for(int i=0;i<30;i++) {
                        if(getX()+60 < 1000 && !isTouchEnemyTank()) {
                            moveRight1();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    for(int i=0;i<30;i++) {
                        if(getY()+60 < 750 && !isTouchEnemyTank()) {
                            moveDown1();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    for(int i=0;i<30;i++) {
                        if(getX() > 0 && !isTouchEnemyTank()) {
                            moveLeft1();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //然后随机的改变坦克方向
            setDirect((int)(Math.random()*4));
            //写并发程序，一定要考虑清楚，该线程什么时候结束
            if(!isLive){
                break;//退出线程
            }
        }
    }
}
