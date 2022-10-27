package tankgame;

import java.util.Vector;

//自己的坦克
public class Hero extends Tank{
    //定义一个射击类
    Shot shot = null;
    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank(){
        //发射多颗子弹，控制我们的面板上最多只有10颗子弹
        if(shots.size() == 10){
            return;
        }
        //创建shot对象，根据Hero对象的位置和方向来创建Shot
        switch (getDirect()){
            case 0:
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2:
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        //把新创建的shot放入到shots中
        shots.add(shot);
        new Thread(shot).start();

    }
}
