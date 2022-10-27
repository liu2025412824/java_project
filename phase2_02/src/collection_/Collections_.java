package collection_;

import java.util.*;

public class Collections_ {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("tom");
        list.add("jack");
        list.add("smith");
        list.add("yilishabai");
        list.add("lzy");
        list.add("zy");

        System.out.println(Collections.max(list));
        System.out.println(Collections.max(list, new Comparator() {
            public int compare(Object o1,Object o2){
                return ((String)o1).length()-((String)o2).length();
            }
        }));

        //完整的拷贝
        List dest = new ArrayList();
        for(int i=0;i<list.size();i++){
            dest.add("");
        }
        Collections.copy(dest,list);
        System.out.println("dest="+dest);

        Collections.replaceAll(list,"lzy","lll");
        System.out.println(list);
    }
}
