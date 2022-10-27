package String_;

public class Test {
    public static void main(String[] args) {
//        System.out.println("E:\\AAA\\BBB");
//        String s = "E:\\AAA\\BBB";
//        String[] split = s.split("\\\\");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }

//        String a = "jvc";
//        String b = "jack";
//        System.out.println(a.compareTo(b));

//        String s2 = "hello";
//        char[] chs = s2.toCharArray();

         String name = "jack";
         int age =10;
         double score = 98.3/3;
         char gender = '男';
        System.out.println(String.format("我叫%s,今年%d岁了,考了%.2f分，性别是%c",name,age,score,gender));

    }
}
