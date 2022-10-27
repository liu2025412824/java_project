package codeblock;

public class code1 {
    public static void main(String[] args) {
        Movie m1 = new Movie("你好李焕英");
        Movie m2 = new Movie("你好李焕英",34.5);
    }
}

class Movie{

    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正式开始...");
    }

    private String name;
    private double price;
    private  String director;

    public Movie(String name) {
        System.out.println("Movie(String name)被调用");
        this.name = name;
    }
    public Movie(String name, double price) {
        System.out.println("Movie(String name, double price)被调用");
        this.name = name;
        this.price = price;
    }
    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }


}
