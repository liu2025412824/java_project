package list_;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

//        linkedList.remove(1);
//        System.out.println(linkedList);

        linkedList.set(0,"haha");
        System.out.println(linkedList);

//        for (Object o :linkedList) {
//            System.out.println(o);
//        }

//        Iterator iterator = linkedList.iterator();
//        while(iterator.hasNext()){
//            Object obj = iterator.next();
//            System.out.println(obj);
//        }
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

    }
}
