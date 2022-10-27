package date_;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        LocalDateTime ldt =LocalDateTime.now();
        System.out.println(ldt);
        System.out.println("年："+ldt.getYear());
        System.out.println("月："+ldt.getMonthValue());
        System.out.println("日："+ldt.getDayOfMonth());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        String time = dtf.format(ldt);
        System.out.println(time);

        LocalDateTime loc = ldt.plusDays(890);
        System.out.println("890天后："+dtf.format(loc));

        LocalDateTime loc2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟以前："+dtf.format(loc2));

        Instant now = Instant.now();
        System.out.println(now);
        Date date = Date.from(now);
        System.out.println(date);

    }
}
