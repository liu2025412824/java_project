package map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超","凳子");
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");

        System.out.println(map);
        map.remove("宋喆");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        //map.clear();
        System.out.println(map.containsKey("王宝强"));
        System.out.println(map.containsValue("马蓉"));


    }
}
