package tankgame;

public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct;//坦克的方向
    boolean isLive = true;
    private int speed = 1;
    int su = 15;

    //我方上下移动方法
    public void moveUp(){
        y -= (speed+su);
    }
    public void moveRight(){
        x += (speed+su);
    }
    public void moveDown(){
        y += (speed+su);
    }
    public void moveLeft(){
        x -= (speed+su);
    }
    //敌方上下移动方法
    public void moveUp1(){
        y -= speed;
    }
    public void moveRight1(){
        x += speed;
    }
    public void moveDown1(){
        y += speed;
    }
    public void moveLeft1(){
        x -= speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getDirect() {
        return direct;
    }
    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
