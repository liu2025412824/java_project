package single_;

public class singleTon02 {
    public static void main(String[] args) {
        //饿汉式在访问一个单例类时的属性时，不会默认给你创建一个对象
        System.out.println(Cat.useful);

        //主动创建一个对象才会创建
        Cat cat = Cat.getCat();
        System.out.println(cat);
    }

}


//希望在程序运行过程中，只能创建一个Cat对象
//使用单例模式
class Cat{
    private String name;
    public static int useful = 66;

    private static Cat cat;

    private Cat(String name) {
        this.name = name;
    }
    public static Cat getCat(){
        if(cat == null){
           cat = new Cat("小花");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}