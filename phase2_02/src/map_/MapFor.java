package map_;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("黄晓明","杨颖");
        map.put("刘亦菲","刘昊然");

        Set set = map.keySet();
        for(Object key:set){
            System.out.println(key+" "+map.get(key));
        }

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj+" "+map.get(obj));
        }
        System.out.println("===========================================================");
        Collection values = map.values();
        //这里可以使用所有的Collections使用的遍历方法
        for (Object o :values) {
            System.out.println(o);
        }

        Iterator iterator2 = values.iterator();
        while(iterator2.hasNext()){
            Object obj = iterator2.next();
            System.out.println(obj);
        }
        System.out.println("===========================================================");
        Set entrySet = map.entrySet();
        for (Object entry:entrySet){
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println();
        Iterator iterator3 = entrySet.iterator();
        while(iterator3.hasNext()){
            Object obj = iterator3.next();
            Map.Entry m = (Map.Entry)obj;
            System.out.println(m.getKey()+" "+m.getValue());
        }

    }
}
