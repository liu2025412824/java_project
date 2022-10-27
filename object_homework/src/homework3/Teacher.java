package homework3;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }
    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public String teach(){
        return "我承诺，我会认真教学";
    }

    @Override
    public String play() {
        return getName()+super.play()+"象棋";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "work_age=" + work_age +
                '}'+super.toString();
    }
}
