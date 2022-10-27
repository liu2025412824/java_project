package collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("红楼梦");
        list.add("三国演义");
        list.add("西游记");
        list.add(100);
        list.add(true);
        System.out.println("list:"+list);
        list.remove(2);
        list.remove("三国演义");
        System.out.println(list);
        System.out.println(list.contains(100));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        //list.clear();
        List list2 = new ArrayList();
        list2.add("aa");
        list2.add("bb");
        list.addAll(list2);
        System.out.println(list);
        System.out.println(list.containsAll(list2));
        list.removeAll(list2);
        System.out.println(list);

    }
}
