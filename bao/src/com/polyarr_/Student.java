package com.polyarr_;

public class Student extends Person {
    private double Score;
    public Student(String name,int age,double Score){
        super(name,age);
        this.Score = Score;
    }

    public double getScore() {
        return Score;
    }
    public void setScore(double score) {
        Score = score;
    }

    @Override
    public String say() {
        return "学生 "+super.say() + " Score="+Score;
    }
    public void study(){
        System.out.println("学生正在学习...");
    }
}
