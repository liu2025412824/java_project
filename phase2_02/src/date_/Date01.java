package date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        System.out.println(d1);
        Date d2 = new Date(92345678);
        System.out.println(d2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String date = sdf.format(d1);
        System.out.println("当前日期为："+date);

        String s = "1996年01月03日 10:20:30 星期二";
        Date parse = sdf.parse(s);
        System.out.println(parse);
    }
}
