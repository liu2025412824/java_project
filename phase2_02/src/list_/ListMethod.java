package list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {

        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello"+i);
        }
        System.out.println("list="+list);
        list.add(1,"雷阵雨");
        System.out.println(list);
        System.out.println("第五个元素为："+list.get(4));
        list.remove(5);
        System.out.println(list);
        list.set(6,"三国演义");
        System.out.println(list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            //System.out.println(iterator.next());
            System.out.println(obj);
        }
    }
}
