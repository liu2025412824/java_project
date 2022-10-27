package importanthomework;

public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void river(){
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }
    public void common(){
        if(!(vehicles instanceof Horse)){
            vehicles = VehiclesFactory.getHrose();
        }
        vehicles.work();
    }
}
