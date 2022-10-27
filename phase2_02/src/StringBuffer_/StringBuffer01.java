package StringBuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        //String-->StringBuffer
        String str = "hello tom";
        //方式一：使用构造器
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式二：使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //StringBuffer-->String
        //方式一：使用StringBuffer提供的toString方法
        StringBuffer stringBuffer2 = new StringBuffer("hi jerry");
        String s = stringBuffer2.toString();
        //方式二：使用构造器来搞定
        String s1 = new String(stringBuffer2);

    }
}
