package enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
    }
}

enum Season2{
    SPRING("春天","温暖"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    WINTER("冬天","寒冷");
    private String name;
    private String desc;

    private Season2(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}

