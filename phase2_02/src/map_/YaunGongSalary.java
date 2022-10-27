package map_;

import java.util.*;

public class YaunGongSalary {
    public static void main(String[] args) {
        HashMap map =new HashMap();
        map.put("jack",650);
        map.put("tom",12000);
        map.put("smith",2900);

        System.out.println(map);

        map.put("jack",2600);

        Set keySet = map.keySet();
        for (Object o :keySet) {
            map.put(o,(Integer)map.get(o)+100);
        }
        System.out.println(map);

        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o+" "+map.get(o));
        }

        Collection values = map.values();
        for (Object o :values) {
            System.out.println(o);
        }

        Set entrySet = map.entrySet();
        for (Object o:entrySet){
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
