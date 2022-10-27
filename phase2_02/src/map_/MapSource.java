package map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("no1","张无忌");
        map.put("no2","张三丰");

        Set set = map.entrySet();
        System.out.println(set.getClass());
        for (Object obj : set) {

            System.out.println(obj.getClass());
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());



    }
}
