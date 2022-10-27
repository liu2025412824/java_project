package enum_;

public class EnumMethod {
    public static void main(String[] args) {
        Season2 autumn = Season2.AUTUMN;
        System.out.println(autumn.name());
        System.out.println(autumn.ordinal());

        Season2[] valus = Season2.values();
        for(Season2 s:valus){  //增强for循环
            System.out.println(s);
        }

        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1="+autumn1);
        System.out.println(autumn == autumn1);

        System.out.println(Season2.AUTUMN.compareTo((Season2.SPRING)));
    }
}
