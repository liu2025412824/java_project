package importanthomework;

public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(37.5);
        car1.getAir().flow();
        Car car2 = new Car(43);
        car2.getAir().flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            if(temperature >40){
                System.out.println("温度大于40°，空调吹冷风");
            }else if(temperature <=40 && temperature >=0){
                System.out.println("舒适温度，空调不工作");
            }else{
                System.out.println("温度小于0°，关闭空调");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
}
