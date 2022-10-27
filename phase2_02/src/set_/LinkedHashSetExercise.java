package set_;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {

        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(new Car("奥拓",1000));
        lhs.add(new Car("奥迪",3000000));
        lhs.add(new Car("法拉利",70000000));
        lhs.add(new Car("奥迪",3000000));
        lhs.add(new Car("法拉利",70000000));

        System.out.println(lhs);

    }
}

class Car{
    private String name;
    private int price;

    public Car(String name,int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}