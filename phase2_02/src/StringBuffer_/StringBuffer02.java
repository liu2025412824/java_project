package StringBuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("hello");
        s1.append(" tom").append(" and jerry");
        System.out.println(s1);

        s1.delete(5,6);
        System.out.println(s1);
        s1.replace(5,8,"Tom");
        System.out.println(s1);

        int index = s1.indexOf("Tom");
        System.out.println(index);

        s1.insert(5," ");
        System.out.println(s1);
    }
}
