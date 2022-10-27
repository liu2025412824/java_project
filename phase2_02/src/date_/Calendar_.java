package date_;

import java.util.Calendar;


public class Calendar_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        //System.out.println(c);

        System.out.println("年："+c.get(Calendar.YEAR));
        System.out.println("时:"+c.get(Calendar.HOUR_OF_DAY));
    }
}
