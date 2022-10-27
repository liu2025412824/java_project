package com.polyparameter_;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getAnnual(){
        return 12*getSalary() + bonus;
    }
    public void manage(){
        System.out.println(getName()+"经理正在监视摸鱼...");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
