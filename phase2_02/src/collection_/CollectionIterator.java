package collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义","罗贯中",35.4));
        col.add(new Book("水浒传","施耐庵",38.4));
        col.add(new Book("红楼梦","曹雪芹",65.4));
    //迭代器遍历
        Iterator iterator = col.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println("obj="+obj);
        }
//        // 再次遍历需要重置迭代器
//        iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Object obj = iterator.next();
//            System.out.println("obj="+obj);
//        }

    //增强for循环遍历
        for(Object book:col){
            System.out.println("book="+book);
        }

        
    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
