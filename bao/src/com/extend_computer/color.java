package com.extend_computer;

public class color extends Computer {
    private String color;

    public color(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo(){
        System.out.println("color信息为:");
        System.out.println(getDetails()+" color:"+color);
    }
}
