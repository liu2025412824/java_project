package tankgame;

/**
 * @author Lzy
 * @version 1.0
 */
public class Shot implements Runnable{
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct = 0;//子弹方向
    int speed = 7;//子弹的速度
    boolean isLive = true;//子弹是否还存活

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() { //射击
        while(true){
            //休眠50毫秒，防止子弹嗖的一下过去
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch(direct){
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            System.out.println("子弹x="+x+" y="+y);
            //当子弹移动到面板的边界时，就应该销毁(把启动的子弹的线程销毁)
            if(!(x >= 0 && x<= 1000 && y >= 0 && y<= 750 && isLive)){
                isLive = false;
                break;
            }
        }
    }
}
