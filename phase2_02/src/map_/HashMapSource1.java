package map_;

import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashMapSource1 {
    public static void main(String[] args) {

        HashMap hmp = new HashMap();
        hmp.put("1","hhh");
        hmp.put("2","hihihi");
        hmp.put("1","hahaha");

        System.out.println(hmp);
    }
}
