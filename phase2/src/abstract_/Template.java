package abstract_;

public abstract class Template {

    public abstract void job();

    public void calculateTime(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间为 "+(end-start));
    }
}
