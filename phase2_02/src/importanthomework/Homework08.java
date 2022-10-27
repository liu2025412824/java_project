package importanthomework;

public class Homework08 {
    public static void main(String[] args) {
        Color color = Color.GREEN;
        color.show();
        switch (color){
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            case GREEN:
                System.out.println("匹配到绿色");
                break;
            default:
                System.out.println("没有匹配到");
        }
    }
}

interface IM{
    void show();
}
enum Color implements IM{
    RED(255,0,0),BLUE(0,0,255),
    YELLOW(255,255,0),GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public void show(){
        System.out.println("属性为："+redValue+","+greenValue+","+blueValue);
    }
}
