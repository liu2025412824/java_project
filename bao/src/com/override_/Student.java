package com.override_;

public class Student extends Person{
    private String id;
    private double Score;

    public Student(String name,int age,String id,double Score){
        super(name,age);
        this.id = id;
        this.Score = Score;
    }

    public String say(){
        return super.say()+" id:"+id+" Score:"+Score;
    }
}
