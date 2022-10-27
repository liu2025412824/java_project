package importanthomework;

public class VehiclesFactory {
    //马儿始终是同一匹马  (单例模式)
    private static Horse horse = new Horse();//饿汉式

    private VehiclesFactory(){}

    public static Horse getHrose(){
        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }
}
