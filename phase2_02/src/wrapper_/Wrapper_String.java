package wrapper_;

import org.junit.jupiter.api.Test;

public class Wrapper_String {
    public static void main(String[] args) {
        Integer i = 100;
        String s1 = i+"";
        String s2 = i.toString();
        String s3 = String.valueOf(i);

        String str = "12345";
        Integer i1 = new Integer(str);
        Integer i2 = Integer.valueOf(str);
        Integer i3 = Integer.parseInt(str);

    }

    @Test
    public void test(){
        Object o1 = true ?new Integer(1):new Double(2.0);
        System.out.println(o1);
    }
}
